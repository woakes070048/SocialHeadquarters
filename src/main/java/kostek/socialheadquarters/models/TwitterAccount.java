package kostek.socialheadquarters.models;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * Created by Michal Kostewicz on 04.04.16.
 */
@Document( indexName = "brands_data" , type = "twitter")
public class TwitterAccount extends AbstractSocialMediaAccount{

}
