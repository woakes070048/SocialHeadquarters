package kostek.socialheadquarters.services;

import kostek.socialheadquarters.models.Brand;
import kostek.socialheadquarters.models.FacebookAccount;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
public interface FacebookAccountService extends BasicAppService<FacebookAccount> {
    Brand findBrandByFacebookAccountId(Long faceAccountId);

    boolean isEntityExist(FacebookAccount entity);
}
