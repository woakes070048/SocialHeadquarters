package pl.codeaddict.socialheadquarters.config;

import pl.codeaddict.socialheadquarters.config.annotations.SkipAtTests;

import pl.codeaddict.socialheadquarters.models.Brand;
import pl.codeaddict.socialheadquarters.models.facebook.FacebookAccount;
import pl.codeaddict.socialheadquarters.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Created by Michal Kostewicz on 07.03.16.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "pl.codeaddict.socialheadquarters.repositories")
@ComponentScan(basePackages = "pl.codeaddict.socialheadquarters",
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = SkipAtTests.class))
public class SpringDataElasticsearchConfigForTest {
    @Autowired
    ElasticsearchClientFactory elasticsearchClientFactory;

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
            elasticsearchClientFactory.createClient();
        ElasticsearchOperations elasticsearchOperations = new ElasticsearchTemplate(elasticsearchClientFactory.getClient());
        //We need to add facebookAccount first because it has parent and need to be created first
        elasticsearchOperations.createIndex(FacebookAccount.class);
        elasticsearchOperations.putMapping(FacebookAccount.class);
        elasticsearchOperations.createIndex(Brand.class);
        elasticsearchOperations.putMapping(Brand.class);
        elasticsearchOperations.createIndex(User.class);
        elasticsearchOperations.putMapping(User.class);
        return elasticsearchOperations;
    }

}
