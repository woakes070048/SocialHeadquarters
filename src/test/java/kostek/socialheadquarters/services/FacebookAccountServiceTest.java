package kostek.socialheadquarters.services;

import kostek.socialheadquarters.config.SpringDataElasticsearchConfigForTest;
import kostek.socialheadquarters.models.Brand;
import kostek.socialheadquarters.models.FacebookAccount;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataElasticsearchConfigForTest.class})
public class FacebookAccountServiceTest {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    BrandService brandService;
    @Autowired
    FacebookAccountService facebookAccountService;

    @Before
    public void setUp() throws InterruptedException {
        Thread.sleep(700);
        brandService.save(new Brand(null, "Nike", "Nice shoes and cloths."));
        facebookAccountService.save(new FacebookAccount(null, "123rtt", "secret1", 1L));
        facebookAccountService.save(new FacebookAccount(null, "345rtt", "secret2", 1L));
        facebookAccountService.save(new FacebookAccount(null, "567rtt", "secret3", null));
    }

    @After
    public void clearData() {
        brandService.deleteAll();
        facebookAccountService.deleteAll();
    }

    @Test
    public void findAllFacebookAccountTest() {
        Set<FacebookAccount> faceAccountsFounded = facebookAccountService.findAllEntities();
        Assert.assertNotNull(faceAccountsFounded);
        Assert.assertEquals(3, faceAccountsFounded.size());
    }

    @Test
    public void findByIdTest() {
        FacebookAccount faceAccountFounded = facebookAccountService.findById(3L);
        Assert.assertNotNull(faceAccountFounded);
        Assert.assertEquals(Long.valueOf(3), faceAccountFounded.getId());
    }

    @Test
    public void saveFacebookAccountTest() {
        FacebookAccount newFaceAccount = new FacebookAccount(null, "123rtt", "secret1", 1L);
        facebookAccountService.save(newFaceAccount);

        FacebookAccount faceAccountFounded = facebookAccountService.findById(4L);
        Assert.assertNotNull(faceAccountFounded);
        Assert.assertEquals(newFaceAccount, faceAccountFounded);
    }

    @Test
    public void updateFacebookAccountTest() {
        FacebookAccount faceAccountForUpdate = facebookAccountService.findById(3L);
        faceAccountForUpdate.setAppId("AppKeySet");
        facebookAccountService.updateEnity(faceAccountForUpdate);

        FacebookAccount faceAccountFounded = facebookAccountService.findById(3L);
        Assert.assertEquals("AppKeySet", faceAccountFounded.getAppId());
    }

    @Test
    public void deleteFacebookAccountByIdTest() {
        FacebookAccount faceAccountForDelete = facebookAccountService.findById(3L);
        Assert.assertNotNull(faceAccountForDelete);

        facebookAccountService.deleteEntityById(3L);
        elasticsearchTemplate.refresh(FacebookAccount.class);
        elasticsearchTemplate.refresh(Brand.class);

        FacebookAccount faceAccountDeleted = facebookAccountService.findById(3L);
        Assert.assertNull(faceAccountDeleted);
    }

    @Test
    public void isFacebookAccountExistTest() {
        FacebookAccount existingFaceAcount= facebookAccountService.findById(1L);
        Assert.assertNotNull(existingFaceAcount);

        boolean faceAccountExist = facebookAccountService.isEntityExist(existingFaceAcount);
        Assert.assertEquals(true, faceAccountExist);
    }


    @Test
    public void findBrandForFacebookAccount() {
    Brand brandFounded = facebookAccountService.findBrandByFacebookAccountId(1L);
        Assert.assertEquals("Nike" , brandFounded.getName());
    }
}
