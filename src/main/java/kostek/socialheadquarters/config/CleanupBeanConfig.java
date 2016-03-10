package kostek.socialheadquarters.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

/**
 * Created by Michal Kostewicz on 10.03.16.
 */
public class CleanupBeanConfig implements DisposableBean {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public CleanupBeanConfig() {
        super();
    }

    @Override
    public void destroy() {
        logger.info("Starting shutdown process - cleanup");

        logger.info("Finishing shutdown process - cleanup");
    }
}
