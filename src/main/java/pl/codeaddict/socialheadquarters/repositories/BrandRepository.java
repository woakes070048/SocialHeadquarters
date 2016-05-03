package pl.codeaddict.socialheadquarters.repositories;

import pl.codeaddict.socialheadquarters.models.Brand;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@Repository("brandRepository")
public interface BrandRepository extends ElasticsearchRepository<Brand,Long> {
//Spring Data provide most CRUD methods for us and rest of them are made taking method name
List<Brand> findByName(String name);

}
