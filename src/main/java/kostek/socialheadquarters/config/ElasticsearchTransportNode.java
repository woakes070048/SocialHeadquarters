package kostek.socialheadquarters.config;

import kostek.socialheadquarters.config.annotations.SkipAtTests;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created by Michal Kostewicz on 20.03.16.
 */
@SkipAtTests
@PropertySource("classpath:transport_node.properties")
@Component
public class ElasticsearchTransportNode implements ElasticsearchClientFactory {
    @Value("${addres}")
    String addres;
    @Value("${port}")
    String port;
    @Value("${cluster}")
    String clusterName;

    private Client client;

    public void createClient() {
        Settings.Builder builder = Settings.builder();
        setClusterName(builder);
        TransportClient client = TransportClient.builder().settings(builder.build()).build();
        try {
            InetAddress realAddres = InetAddress.getByName(addres);
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(realAddres.getHostName()), Integer.valueOf(port)));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        this.client = client;

    }

    private void setClusterName(Settings.Builder builder) {
        if (StringUtils.isNotBlank(clusterName)) {
            builder.put("cluster.name", clusterName);
        }
    }

    public Client getClient() {
        return client;
    }

    public void closeClient() {
        client.close();

    }
}

