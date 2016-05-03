package pl.codeaddict.socialheadquarters.services.implementations;

import pl.codeaddict.socialheadquarters.models.User;
import pl.codeaddict.socialheadquarters.repositories.UserRepository;
import pl.codeaddict.socialheadquarters.services.AbstractBasicAppService;
import pl.codeaddict.socialheadquarters.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;

/**
 * Created by kostek on 02.03.16.
 */
@Service("userService")
@Transactional
public class UserServiceImpl extends AbstractBasicAppService<User> implements UserService {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    UserRepository userRepository;

    @Override
    public Set<User> findAllEntities() {
        Set<User> userSet = new HashSet<User>();
        for (User user : userRepository.findAll()) {
            userSet.add(user);
        }
        return userSet;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public void saveEntity(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateEnity(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteEntityById(Long id) {
        userRepository.delete(id);

    }

    @Override
    public boolean isEntityExist(User user) {
        return !findByName(user.getName()).isEmpty();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public Class<User> getServiceDependentClass() {
        return User.class;
    }

}
