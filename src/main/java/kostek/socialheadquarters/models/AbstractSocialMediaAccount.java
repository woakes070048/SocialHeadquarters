package kostek.socialheadquarters.models;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by Michal Kostewicz on 04.04.16.
 */
public abstract class AbstractSocialMediaAccount extends AbstractBasicAppEntity{

    @Field(type = FieldType.Long, store = true)
    protected  Long brandId;

    @Field(type = FieldType.String, store = true)
    protected String accountName;

    public AbstractSocialMediaAccount() {
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractSocialMediaAccount that = (AbstractSocialMediaAccount) o;

        if (brandId != null ? !brandId.equals(that.brandId) : that.brandId != null) return false;
        return accountName != null ? accountName.equals(that.accountName) : that.accountName == null;

    }

    @Override
    public int hashCode() {
        int result = brandId != null ? brandId.hashCode() : 0;
        result = 31 * result + (accountName != null ? accountName.hashCode() : 0);
        return result;
    }
}
