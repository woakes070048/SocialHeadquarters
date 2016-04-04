package kostek.socialheadquarters.services.implementations;

import kostek.socialheadquarters.models.Brand;
import kostek.socialheadquarters.models.FacebookAccount;
import kostek.socialheadquarters.models.User;
import kostek.socialheadquarters.repositories.BrandRepository;
import kostek.socialheadquarters.services.AbstractBasicAppService;
import kostek.socialheadquarters.services.BrandService;
import org.elasticsearch.index.search.MultiMatchQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@Service("brandService")
@Transactional
public class BrandServiceImpl extends AbstractBasicAppService<Brand> implements BrandService{
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Resource
    BrandRepository brandRepository;

    @Override
    public Set<Brand> findAllEntities() {
        Set<Brand> brandSet = new HashSet<>();
        for (Brand brand : brandRepository.findAll()) {
            brandSet.add(brand);
        }
        return brandSet;
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findOne(id);
    }

    @Override
    public List<Brand> findByName(String name) {
        return brandRepository.findByName(name);
    }

    public void saveEntity(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void updateEnity(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void deleteEntityById(Long id) {
        brandRepository.delete(id);

    }

    @Override
    public boolean isEntityExist(Brand brand) {
        return !findByName(brand.getName()).isEmpty();
    }

    @Override
    public void deleteAll() {
        brandRepository.deleteAll();
    }

    @Override
    public Class<Brand> getServiceDependentClass() {
        return Brand.class;
    }

    @Override
    public FacebookAccount findFacebookAccountByBrandId(Long brandId) {
        CriteriaQuery criteriaQuery = new CriteriaQuery(new Criteria("brandId").is(brandId));
        // when
        List<FacebookAccount> page = elasticsearchTemplate.queryForList(criteriaQuery, FacebookAccount.class);
        if (page.size() < 1){
            return null;
        }
        return page.get(0);
    }
}
