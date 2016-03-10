package kostek.socialheadquarters.services;

import kostek.socialheadquarters.models.User;

import java.util.List;
import java.util.Set;

/**
 * Created by kostek on 02.03.16.
 */
public interface UserService {
    User findById(Long id);

    List<User> findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    Set<User> findAllUsers();

    boolean isUserExist(User user);

    void deleteAll();

    Long findMaxId();

}