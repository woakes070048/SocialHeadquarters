package kostek.socialheadquarters.models;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@Document( indexName = "brands_data" , type = "facebook")
public class FacebookAccount extends AbstractSocialMediaAccount{
    private String appKey;

    private String appSecret;

    public FacebookAccount(Long id, String appKey, String appSecret, Long brandId) {
        this.id = id;
        this.appKey = appKey;
        this.appSecret = appSecret;
        this.brandId = brandId;
    }

    public FacebookAccount() {
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FacebookAccount that = (FacebookAccount) o;

        if (!appKey.equals(that.appKey)) return false;
        return appSecret.equals(that.appSecret);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + appKey.hashCode();
        result = 31 * result + appSecret.hashCode();
        return result;
    }
}
