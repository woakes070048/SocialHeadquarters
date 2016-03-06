package kostek.socialheadquarters.config;

import org.elasticsearch.client.node.NodeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.util.UUID;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by Michal Kostewicz on 06.03.16.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "kostek.socialheadquarters")
public class SpringDataElasticsearchConfig {

    @Autowired
    private ElasticsearchTemplate template;


    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        return new ElasticsearchTemplate(getNodeClient());
    }

    private static NodeClient getNodeClient() {
        return (NodeClient) nodeBuilder().clusterName(UUID.randomUUID().toString()).local(true).node()
                .client();

    }

}
