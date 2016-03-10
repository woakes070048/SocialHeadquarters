package kostek.socialheadquarters.services.implementations;

import kostek.socialheadquarters.models.User;
import kostek.socialheadquarters.repositories.UserRepository;
import kostek.socialheadquarters.services.UserService;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.aggregations.Aggregations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ResultsExtractor;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;
import org.elasticsearch.action.search.SearchResponse;

import javax.annotation.Resource;
import javax.naming.directory.SearchResult;
import javax.transaction.Transactional;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static org.elasticsearch.action.search.SearchType.COUNT;
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
        // given
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchAllQuery())
                .withSearchType(COUNT)
                .withIndices("user").withTypes("appuser")
                .build();
        Long result = elasticsearchTemplate.query(searchQuery, new ResultsExtractor<Long>() {

            @Override
            public Long extract(SearchResponse response) {
                long totalHits = response.getHits()
                        .totalHits();
                List<String> ids = new ArrayList<String>();
                for (SearchHit hit : response.getHits()) {
                    if (hit != null) {
                        ids.add(hit.getId());
                    }
                }
                return totalHits;
            }
        });
        System.out.println(result);
        return result;
    }
}
