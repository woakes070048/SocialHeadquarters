package kostek.socialheadquarters.services;

import kostek.socialheadquarters.models.AbstractBasicAppEntity;
import kostek.socialheadquarters.models.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Michal Kostewicz on 13.03.16.
 */
public interface BasicAppService<T extends AbstractBasicAppEntity> {
    T findById(Long id);

    void updateEnity(T entity);

    void deleteEntityById(Long id);

    Set<T> findAllEntities();

    void deleteAll();

    Class<T> getServiceDependentClass();

    Long findNewMaxId();

    void save(T entity);
}
