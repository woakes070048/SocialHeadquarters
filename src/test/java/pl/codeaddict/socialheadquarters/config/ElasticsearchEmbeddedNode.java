package pl.codeaddict.socialheadquarters.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.springframework.stereotype.Component;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by Michal Kostewicz on 20.03.16.
 */
@Component
public class ElasticsearchEmbeddedNode implements ElasticsearchClientFactory{
    private static final String DEFAULT_DATA_DIRECTORY = "target/elasticsearch-data";
    private Node node;
    private String dataDirectory;

    public ElasticsearchEmbeddedNode() {
        this(DEFAULT_DATA_DIRECTORY);
    }

    public ElasticsearchEmbeddedNode(String dataDirectory) {
        this.dataDirectory = DEFAULT_DATA_DIRECTORY;
    }

    @Override
    public void createClient(){
        if (node == null) {
            Settings.Builder elasticsearchSettings = Settings.settingsBuilder()
                    .put("http.enabled", "false")
                    .put("path.home", dataDirectory);

            node = nodeBuilder()
                    .local(true)
                    .settings(elasticsearchSettings.build())
                    .node();
        }else {
            node.start();
        }
    }

    @Override
    public Client getClient() {
        return node.client();
    }

    @Override
    public void closeClient() {

    }
}