package pl.codeaddict.socialheadquarters.services;

import pl.codeaddict.socialheadquarters.models.Brand;
import pl.codeaddict.socialheadquarters.models.facebook.FacebookAccount;

import java.util.List;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
public interface BrandService extends BasicAppService<Brand>{
    List<Brand> findByName(String name);

    boolean isEntityExist(Brand entity);

    FacebookAccount findFacebookAccountByBrandId(Long brandId);
}
