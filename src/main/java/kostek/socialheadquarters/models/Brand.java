package kostek.socialheadquarters.models;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@Document( indexName = "brands_data" , type = "brand")
public class Brand extends AbstractBasicAppEntity {
    @Field(
            type = FieldType.String,
            index = FieldIndex.analyzed,
            store = true
    )
    private String name;

    private String description;

    public Brand(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Brand() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Brand brand = (Brand) o;

        if (name != null ? !name.equals(brand.name) : brand.name != null) return false;
        return description != null ? description.equals(brand.description) : brand.description == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
