package kostek.socialheadquarters.config;

import kostek.socialheadquarters.config.annotations.SkipAtTests;
import kostek.socialheadquarters.models.User;
import org.elasticsearch.client.Client;
import org.elasticsearch.cluster.ClusterName;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.util.concurrent.EsExecutors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by Michal Kostewicz on 06.03.16.
 */
@SkipAtTests
@Configuration
@EnableElasticsearchRepositories(basePackages = "kostek.socialheadquarters.repositories")
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

}
