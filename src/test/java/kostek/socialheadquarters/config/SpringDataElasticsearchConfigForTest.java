package kostek.socialheadquarters.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.cluster.ClusterName;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.util.concurrent.EsExecutors;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.nio.file.Path;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by Michal Kostewicz on 07.03.16.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "kostek.socialheadquarters.repositories")
public class SpringDataElasticsearchConfigForTest {
    private Path dataDirectory;

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        return new ElasticsearchTemplate(getNodeClient());
    }

    private static Client getNodeClient() {
        Settings settings = ImmutableSettings.settingsBuilder()
                .put(ClusterName.SETTING, "Test")
                .put(IndexMetaData.SETTING_NUMBER_OF_SHARDS, 1)
                .put(IndexMetaData.SETTING_NUMBER_OF_REPLICAS, 0)
                .put(EsExecutors.PROCESSORS, 1)
                //.put("index.store.type", "memory")
                .put("path.home", "/home/kostek/elasticsearch/").build();
        return nodeBuilder().local(true).data(true).settings(settings).node().client();
    }

}
