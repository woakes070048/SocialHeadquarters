package pl.codeaddict.socialheadquarters.config;

import pl.codeaddict.socialheadquarters.config.annotations.SkipAtTests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * Created by Michal Kostewicz on 06.03.16.
 */
@SkipAtTests
@Configuration
@EnableElasticsearchRepositories(basePackages = "pl.codeaddict.socialheadquarters.repositories")
public class SpringDataElasticsearchConfig {
    @Autowired
    ElasticsearchClientFactory elasticsearchClientFactory;
    @Value("${partition}")
    String partition;

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        elasticsearchClientFactory.createClient();
        return new ElasticsearchTemplate(elasticsearchClientFactory.getClient());
    }

    @Bean
    public String indexPattern(){
        String indexPattern = null;
        indexPattern = partition;
        return indexPattern;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }


}
