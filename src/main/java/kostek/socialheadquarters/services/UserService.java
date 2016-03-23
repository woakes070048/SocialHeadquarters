package kostek.socialheadquarters.services;

import kostek.socialheadquarters.models.User;

import java.util.List;
import java.util.Set;

/**
 * Created by kostek on 02.03.16.
 */
public interface UserService extends BasicAppService<User> {
    User findById(Long id);

    List<User> findByName(String name);

    void save(User user);

    void updateEnity(User user);

    void deleteEntityById(Long id);

    Set<User> findAllEntities();

    boolean isEntityExist(User user);

}