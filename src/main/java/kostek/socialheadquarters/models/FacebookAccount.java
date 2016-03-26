package kostek.socialheadquarters.models;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@Document( indexName = "brands_data" , type = "facebook")
public class FacebookAccount extends AbstractBasicAppEntity{
    private String appKey;

    private String appSecret;

    @Field(type = FieldType.Long, store = true)
    private Long brandId;

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

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FacebookAccount that = (FacebookAccount) o;

        if (appKey != null ? !appKey.equals(that.appKey) : that.appKey != null) return false;
        if (appSecret != null ? !appSecret.equals(that.appSecret) : that.appSecret != null) return false;
        return brandId != null ? brandId.equals(that.brandId) : that.brandId == null;

    }

    @Override
    public int hashCode() {
        int result = appKey != null ? appKey.hashCode() : 0;
        result = 31 * result + (appSecret != null ? appSecret.hashCode() : 0);
        result = 31 * result + (brandId != null ? brandId.hashCode() : 0);
        return result;
    }
}
