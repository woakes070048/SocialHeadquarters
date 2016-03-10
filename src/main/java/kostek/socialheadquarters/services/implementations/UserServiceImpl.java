package kostek.socialheadquarters.services.implementations;

import kostek.socialheadquarters.models.User;
import kostek.socialheadquarters.repositories.UserRepository;
import kostek.socialheadquarters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by kostek on 02.03.16.
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
   @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    UserRepository userRepository;

    public final AtomicLong counter = new AtomicLong();

    public List<User> users = new ArrayList<>();

    @Override
    public Set<User> findAllUsers() {
        Set<User> userSet = new HashSet<User>();
        for (User user : userRepository.findAll()) {
            userSet.add(user);
        }
        return userSet;
    }

    @Override
    public User findById(String id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.delete(id);

    }

    @Override
    public boolean isUserExist(User user) {
        return !findByName(user.getName()).isEmpty();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public String findMaxId() {
        return userRepository.findTopByOrderByIdDesc();
    }
}
