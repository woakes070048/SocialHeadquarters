package kostek.socialheadquarters.models;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@Document( indexName = "brands_data" , type = "facebook")
public class FacebookAccount extends AbstractSocialMediaAccount{

    @Field(type = FieldType.String, store = true)
    private String appId;

    @Field(type = FieldType.String, store = true)
    private String secretKey;

    public FacebookAccount(Long id, String appId, String secretKey, Long brandId) {
        this.id = id;
        this.appId = appId;
        this.secretKey = secretKey;
        this.brandId = brandId;
    }

    public FacebookAccount() {
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FacebookAccount that = (FacebookAccount) o;

        if (!appId.equals(that.appId)) return false;
        return secretKey.equals(that.secretKey);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + appId.hashCode();
        result = 31 * result + secretKey.hashCode();
        return result;
    }
}
