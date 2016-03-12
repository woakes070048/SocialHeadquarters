package kostek.socialheadquarters.services;

import kostek.socialheadquarters.models.AbstractBasicAppEntity;

/**
 * Created by Michal Kostewicz on 13.03.16.
 */
public interface BasicAppService<T extends AbstractBasicAppEntity> {
    void deleteAll();
    Class<T> getServiceDependentClass();
    Long findMaxId();
}
