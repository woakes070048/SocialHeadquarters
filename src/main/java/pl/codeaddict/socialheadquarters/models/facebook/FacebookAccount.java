package pl.codeaddict.socialheadquarters.models.facebook;

import pl.codeaddict.socialheadquarters.models.AbstractSocialMediaAccount;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@Document( indexName = "brands_data" , type = "facebook")
public class FacebookAccount extends AbstractSocialMediaAccount {

    @Field(type = FieldType.String, store = true)
    private String userId;

    @Field(type = FieldType.String, store = true)
    private String accessToken;

    @Field(type = FieldType.Long, store = true)
    private String expiresIn;

    @Field(type = FieldType.Long, store = true)
    private String tokenAcquiredIn;

    public FacebookAccount(Long id, String userId, String accessToken, Long brandId) {
        this.id = id;
        this.userId = userId;
        this.accessToken = accessToken;
        this.brandId = brandId;
    }

    public FacebookAccount() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenAcquiredIn() {
        return tokenAcquiredIn;
    }

    public void setTokenAcquiredIn(String tokenAcquiredIn) {
        this.tokenAcquiredIn = tokenAcquiredIn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        FacebookAccount that = (FacebookAccount) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) return false;
        if (expiresIn != null ? !expiresIn.equals(that.expiresIn) : that.expiresIn != null) return false;
        return tokenAcquiredIn != null ? tokenAcquiredIn.equals(that.tokenAcquiredIn) : that.tokenAcquiredIn == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (accessToken != null ? accessToken.hashCode() : 0);
        result = 31 * result + (expiresIn != null ? expiresIn.hashCode() : 0);
        result = 31 * result + (tokenAcquiredIn != null ? tokenAcquiredIn.hashCode() : 0);
        return result;
    }
}
