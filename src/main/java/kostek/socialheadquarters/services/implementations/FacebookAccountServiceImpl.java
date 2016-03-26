package kostek.socialheadquarters.services.implementations;

import kostek.socialheadquarters.models.Brand;
import kostek.socialheadquarters.models.FacebookAccount;
import kostek.socialheadquarters.repositories.FacebookAccountRepository;
import kostek.socialheadquarters.services.AbstractBasicAppService;
import kostek.socialheadquarters.services.FacebookAccountService;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.index.query.HasChildQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.elasticsearch.index.query.QueryBuilders.hasChildQuery;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@Service("facebookAccountService")
@Transactional
public class FacebookAccountServiceImpl extends AbstractBasicAppService<FacebookAccount> implements FacebookAccountService {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    FacebookAccountRepository facebookAccountRepository;

    @Override
    public Set<FacebookAccount> findAllEntities() {
        Set<FacebookAccount> facebookAccountSet = new HashSet<>();
        for (FacebookAccount brand : facebookAccountRepository.findAll()) {
            facebookAccountSet.add(brand);
        }
        return facebookAccountSet;
    }

    @Override
    public FacebookAccount findById(Long id) {
       return facebookAccountRepository.findOne(id);
    }

    @Override
    public void saveEntity(FacebookAccount facebookAccount) {
        facebookAccountRepository.save(facebookAccount);
    }

    @Override
    public void updateEnity(FacebookAccount facebookAccount) {
        facebookAccountRepository.save(facebookAccount);
    }

    @Override
    public void deleteEntityById(Long id) {
        facebookAccountRepository.delete(id);
    }

    @Override
    public void deleteAll() {
        facebookAccountRepository.deleteAll();
    }

    @Override
    public Class<FacebookAccount> getServiceDependentClass() {
        return FacebookAccount.class;
    }

    @Override
    public Brand findBrandByFacebookAccountId(Long faceAccountId) {
        FacebookAccount facebookAccount = findById(faceAccountId);
        CriteriaQuery criteriaQuery = new CriteriaQuery(new Criteria("id").is(facebookAccount.getBrandId()));
        // when
        List<Brand> page = elasticsearchTemplate.queryForList(criteriaQuery, Brand.class);
        return page.get(0);
    }

    @Override
    public boolean isEntityExist(FacebookAccount entity) {
        return (findById(entity.getId()) != null);
    }
}
