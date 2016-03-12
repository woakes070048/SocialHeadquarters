package kostek.socialheadquarters.services;

import kostek.socialheadquarters.models.AbstractBasicAppEntity;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Component;

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

    protected abstract void deleteAll();

    protected abstract Class<T> getServiceDependentClass();


    public Long findMaxId() {
        System.out.print(getServiceDependentClass().getAnnotation(Document.class).indexName());
        System.out.print(getServiceDependentClass().getAnnotation(Document.class).type());
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withSearchType(QUERY_AND_FETCH)
                .withIndices("user").withTypes("appuser")
                .addAggregation(max("max_id").field("id"))
                .build();
        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, response -> response.getAggregations());
        Max max = aggregations.get("max_id");
        Long maxValue = (long)max.getValue();
        return maxValue;
    }

    public ElasticsearchTemplate getElasticsearchTemplate() {
        return elasticsearchTemplate;
    }
}
