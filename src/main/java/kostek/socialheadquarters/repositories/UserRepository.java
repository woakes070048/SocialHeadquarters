package kostek.socialheadquarters.repositories;

import kostek.socialheadquarters.models.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Michal Kostewicz on 06.03.16.
 */
@Repository("userRepository")
public interface UserRepository extends ElasticsearchRepository<User,String> {
    //Spring Data provide most CRUD methods for us and rest of them are made taking method name

    List<User> findByName(String name);

    List<User> findById(String id);

    String findTopByOrderByIdDesc();
}
