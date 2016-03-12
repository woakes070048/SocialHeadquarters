package kostek.socialheadquarters.services.implementations;

import kostek.socialheadquarters.models.User;
import kostek.socialheadquarters.repositories.UserRepository;
import kostek.socialheadquarters.services.UserService;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.metrics.max.Max;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.elasticsearch.action.search.SearchResponse;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static org.elasticsearch.action.search.SearchType.QUERY_AND_FETCH;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.search.aggregations.AggregationBuilders.max;

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
    
    @Override
    public Set<User> findAllUsers() {
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

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
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
    public Long findMaxId() {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withSearchType(QUERY_AND_FETCH)
                .withIndices("user").withTypes("appuser")
                .addAggregation(max("max_id").field("id"))
                .build();
        Aggregations aggregations = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Aggregations>() {
            @Override
            public Aggregations extract(SearchResponse response) {
                return response.getAggregations();
            }
        });
        Max max = aggregations.get("max_id");
        Long maxValue = (long)max.getValue();
        return maxValue;
    }

}
