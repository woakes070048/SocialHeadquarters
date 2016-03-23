package kostek.socialheadquarters.models;

import kostek.socialheadquarters.utills.annotations.GenerateId;
import org.springframework.data.annotation.Id;

/**
 * Created by Michal Kostewicz on 12.03.16.
 */
public abstract class AbstractBasicAppEntity {
    @Id
    @GenerateId
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
