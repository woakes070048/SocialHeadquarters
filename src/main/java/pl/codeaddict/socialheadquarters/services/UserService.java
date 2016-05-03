package pl.codeaddict.socialheadquarters.services;

import pl.codeaddict.socialheadquarters.models.User;

import java.util.List;

/**
 * Created by Michal Kostewicz on 02.03.16.
 */
public interface UserService extends BasicAppService<User> {
    List<User> findByName(String name);

    boolean isEntityExist(User entity);
}