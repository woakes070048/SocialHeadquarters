package kostek.socialheadquarters.services.implementations;

import kostek.socialheadquarters.models.User;
import kostek.socialheadquarters.repositories.UserRepository;
import kostek.socialheadquarters.services.AbstractBasicAppService;
import kostek.socialheadquarters.services.UserService;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.elasticsearch.action.search.SearchResponse;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;

import static org.elasticsearch.action.search.SearchType.QUERY_AND_FETCH;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.search.aggregations.AggregationBuilders.max;

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
