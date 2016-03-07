package kostek.socialheadquarters.services.implementations;

import kostek.socialheadquarters.models.User;
import kostek.socialheadquarters.repositories.UserRepository;
import kostek.socialheadquarters.services.UserService;
import org.apache.lucene.queryparser.flexible.core.builders.QueryBuilder;
import org.apache.lucene.search.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;

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

    public Set<User> findAllUsers() {
        Set<User> userSet = new HashSet<User>();
        for (User user : userRepository.findAll()) {
            userSet.add(user);
        }
        return userSet;
    }

    public User findById(Long id) {
        return userRepository.findById(id);
    }

    public User findByName(String name) {
        return userRepository.findByUsername(name);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    public void deleteUserById(Long id) {
        userRepository.delete(id);
    }

    public boolean isUserExist(User user) {
        return findByName(user.getUsername())!=null;
    }

    public void deleteAllUsers(){
        users.clear();
    }

}
