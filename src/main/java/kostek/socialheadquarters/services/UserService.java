package kostek.socialheadquarters.services;

import kostek.socialheadquarters.models.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Michal Kostewicz on 02.03.16.
 */
public interface UserService extends BasicAppService<User> {
    List<User> findByName(String name);

    boolean isEntityExist(User entity);
}