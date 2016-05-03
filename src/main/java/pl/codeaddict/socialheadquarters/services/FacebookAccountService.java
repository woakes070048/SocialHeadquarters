package pl.codeaddict.socialheadquarters.services;

import pl.codeaddict.socialheadquarters.models.Brand;
import pl.codeaddict.socialheadquarters.models.facebook.FacebookAccount;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
public interface FacebookAccountService extends BasicAppService<FacebookAccount> {
    Brand findBrandByFacebookAccountId(Long faceAccountId);

    boolean isEntityExist(FacebookAccount entity);
}
