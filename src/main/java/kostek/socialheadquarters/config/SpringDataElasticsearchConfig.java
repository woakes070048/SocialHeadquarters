package kostek.socialheadquarters.config;

import kostek.socialheadquarters.models.User;
import org.elasticsearch.client.Client;
import org.elasticsearch.cluster.ClusterName;
import org.elasticsearch.cluster.metadata.IndexMetaData;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.util.concurrent.EsExecutors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by Michal Kostewicz on 06.03.16.
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "kostek.socialheadquarters.repositories")
public class SpringDataElasticsearchConfig {

    @Bean
    public ElasticsearchTemplate elasticsearchTemplate() {
        ElasticsearchTemplate elasticsearchTemplate = new ElasticsearchTemplate(getNodeClient());
        elasticsearchTemplate.deleteIndex(User.class);
        elasticsearchTemplate.createIndex(User.class);
        elasticsearchTemplate.putMapping(User.class);
        return elasticsearchTemplate;
    }

    private static Client getNodeClient() {
        Settings settings = Settings.settingsBuilder()
                .put(ClusterName.SETTING, "SocialHeadquartersCluster")
                .put(IndexMetaData.SETTING_NUMBER_OF_SHARDS, 1)
                .put(IndexMetaData.SETTING_NUMBER_OF_REPLICAS, 0)
                .put(EsExecutors.PROCESSORS, 1)
                .put("index.mapper.dynamic", "true")
                .put("path.home", "/home/kostek/elasticsearch/").build();
        return nodeBuilder().local(false).data(true).settings(settings).node().client();
    }

}
