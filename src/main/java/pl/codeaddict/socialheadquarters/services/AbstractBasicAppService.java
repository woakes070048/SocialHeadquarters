package pl.codeaddict.socialheadquarters.services;

import pl.codeaddict.socialheadquarters.models.AbstractBasicAppEntity;
import pl.codeaddict.socialheadquarters.utills.annotations.GenerateId;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.elasticsearch.action.search.SearchType.QUERY_AND_FETCH;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.search.aggregations.AggregationBuilders.max;

/**
 * Created by Michal Kostewicz on 12.03.16.
 */
@Component
public abstract class AbstractBasicAppService<T extends AbstractBasicAppEntity> {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    private T object;

    protected abstract void saveEntity(T object);

    protected abstract void deleteAll();

    protected abstract Class<T> getServiceDependentClass();

    public void save(T object) {
        this.object = object;
        try {
            generateId();
            saveEntity(this.object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }

    private void generateId() throws IllegalAccessException {
        Field fieldWithGeneratedIdAnnotation = checkIfHasGeneratedIdAnnotation();
        if (checkIfValueIsSet(fieldWithGeneratedIdAnnotation)) {
            setValueOfField(fieldWithGeneratedIdAnnotation);
        }
    }

    private void setValueOfField(Field fieldWithGeneratedIdAnnotation) throws IllegalAccessException {
        Long newMaxIdForEntity = findNewMaxId();
        fieldWithGeneratedIdAnnotation.set(object , newMaxIdForEntity);
    }

    private Field checkIfHasGeneratedIdAnnotation() {
        List<Field> allClassFields = getAllFields(new ArrayList<>(), object.getClass());
        Field fieldWithGeneratedIdAnnotation = null;
        for (Field classField : allClassFields) {
            if (classField.getAnnotation(GenerateId.class) != null) {
                fieldWithGeneratedIdAnnotation = classField;
            }
        }
        return fieldWithGeneratedIdAnnotation;
    }

    private Boolean checkIfValueIsSet(Field field) throws IllegalAccessException {
        field.setAccessible(true);
        return field.get(object) == null;
    }

    public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
        fields.addAll(Arrays.asList(type.getDeclaredFields()));
        if (type.getSuperclass() != null) {
            fields = getAllFields(fields, type.getSuperclass());
        }
        return fields;
    }

    public Long findNewMaxId() {
        String index = getServiceDependentClass().getAnnotation(Document.class).indexName();
        String type = getServiceDependentClass().getAnnotation(Document.class).type();
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withSearchType(QUERY_AND_FETCH)
                .withIndices(index).withTypes(type)
                .addAggregation(max("max_id").field("id"))
                .build();
        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, response -> response.getAggregations());
        Max max = aggregations.get("max_id");
        Long maxValue = (long) max.getValue();
        if (maxValue < 0 ){
            return 1L;
        }
        return maxValue + 1;
    }

    public ElasticsearchTemplate getElasticsearchTemplate() {
        return elasticsearchTemplate;
    }
}
