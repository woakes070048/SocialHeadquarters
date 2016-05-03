package pl.codeaddict.socialheadquarters.models.facebook;

import pl.codeaddict.socialheadquarters.models.AbstractSocialMediaAccount;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by Michal Kostewicz on 30.04.16.
 */
@Document( indexName = "brands_data" , type = "facebook_post")
public class FacebookPost extends AbstractSocialMediaAccount {

    @Field(type = FieldType.String, store = true)
    private String postText;

    public FacebookPost(String postText, Long brandId) {
        this.postText = postText;
        this.brandId = brandId;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }
}
