package kostek.socialheadquarters.config;

import kostek.socialheadquarters.config.annotations.SkipAtTests;

import kostek.socialheadquarters.models.Brand;
import kostek.socialheadquarters.models.FacebookAccount;
import kostek.socialheadquarters.models.User;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.nio.file.Path;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by Michal Kostewicz on 07.03.16.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "kostek.socialheadquarters.repositories")
@ComponentScan(basePackages = "kostek.socialheadquarters",
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
