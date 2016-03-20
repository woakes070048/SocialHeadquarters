package kostek.socialheadquarters.config;

import org.elasticsearch.client.Client;

/**
 * Created by Michal Kostewicz on 20.03.16.
 */
public interface ElasticsearchClientFactory {
        void createClient();

        Client getClient();

        void closeClient();
}
