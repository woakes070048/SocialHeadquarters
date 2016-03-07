package kostek.socialheadquarters.services;

import kostek.socialheadquarters.models.User;

import java.util.List;
import java.util.Set;

/**
 * Created by kostek on 02.03.16.
 */
public interface UserService {
    User findById(Long id);

    User findByName(String name);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUserById(Long id);

    Set<User> findAllUsers();

    void deleteAllUsers();

    boolean isUserExist(User user);

}