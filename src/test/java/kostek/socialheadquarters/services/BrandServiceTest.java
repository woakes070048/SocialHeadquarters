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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Michal Kostewicz on 25.03.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataElasticsearchConfigForTest.class})
public class BrandServiceTest {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    BrandService brandService;
    @Autowired
    FacebookAccountService facebookAccountService;

    @Before
    public void setUp() throws InterruptedException {
        Thread.sleep(700);
        brandService.save(new Brand(null, "Orange", "Mobile brand, but not only."));
        brandService.save(new Brand(null, "Nike", "Nice shoes and cloths."));
        brandService.save(new Brand(null, "JohnnyQ", "Just Johnny"));
        FacebookAccount facebookAccount = new FacebookAccount(null, "234rtt", "secret", 1L);
        facebookAccountService.save(facebookAccount);
    }

    @After
    public void clearData() {
        brandService.deleteAll();
        facebookAccountService.deleteAll();
    }

    @Test
    public void findAllBrandsTest() {
        Set<Brand> brandFounded = brandService.findAllEntities();
        Assert.assertNotNull(brandFounded);
        Assert.assertEquals(3, brandFounded.size());
    }

    @Test
    public void findByIdTest() {
        Brand brandFounded = brandService.findById(3L);
        Assert.assertNotNull(brandFounded);
        Assert.assertEquals(Long.valueOf(3), brandFounded.getId());
    }

    @Test
    public void findByNameTest() {
        Brand brandFounded = brandService.findByName("Orange").get(0);
        Assert.assertNotNull(brandFounded);
        Assert.assertEquals("Orange", brandFounded.getName());
    }

    @Test
    public void saveBrandTest() {
        Brand newBrand = new Brand(null, "H&M", "Cloths for living");
        brandService.save(newBrand);

        Brand brandFounded = brandService.findByName("H&M").get(0);
        Assert.assertNotNull(brandFounded);
        Assert.assertEquals(newBrand, brandFounded);
    }

    @Test
    public void updateBrandTest() {
        Brand brandForUpdate = brandService.findById(3L);
        brandForUpdate.setName("SomeBrand");
        brandService.updateEnity(brandForUpdate);

        List<Brand> brandNotFounded = brandService.findByName("JohnnyQ");
        Assert.assertEquals(new ArrayList(), brandNotFounded);

        Brand brandFounded = brandService.findByName("SomeBrand").get(0);
        Assert.assertEquals(brandForUpdate, brandFounded);
    }

    @Test
    public void deleteBrandByIdTest() {
        Brand brandForDelete = brandService.findById(3L);
        Assert.assertNotNull(brandForDelete);

        brandService.deleteEntityById(3L);
        Brand brandDeleted = brandService.findById(3L);
        Assert.assertNull(brandDeleted);
    }

    @Test
    public void isBrandExistTest() {
        Brand existingBrand = brandService.findById(1L);
        Assert.assertNotNull(existingBrand);

        boolean brandExist = brandService.isEntityExist(existingBrand);
        Assert.assertEquals(true, brandExist);
    }

    @Test
    public void findNewMaxIdTest() {
        Long maxId = brandService.findNewMaxId();
        Assert.assertEquals(Long.valueOf(4), maxId);
    }

    @Test
    public void findFacebookAccountForBrand() {
        FacebookAccount foundedFaceAccount = brandService.findFacebookAccountByBrandId(1L);
        Assert.assertEquals(Long.valueOf(1), foundedFaceAccount.getBrandId());
    }
}
