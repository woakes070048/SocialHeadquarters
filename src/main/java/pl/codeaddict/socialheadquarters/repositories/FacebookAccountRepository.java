package pl.codeaddict.socialheadquarters.repositories;

import pl.codeaddict.socialheadquarters.models.facebook.FacebookAccount;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@Repository("facebookAccountRepository")
public interface FacebookAccountRepository extends ElasticsearchRepository<FacebookAccount,Long> {
    //Spring Data provide most CRUD methods for us and rest of them are made taking method name
}
