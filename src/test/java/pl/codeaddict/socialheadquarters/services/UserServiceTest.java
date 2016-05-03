package pl.codeaddict.socialheadquarters.services;

import pl.codeaddict.socialheadquarters.config.SpringDataElasticsearchConfigForTest;
import pl.codeaddict.socialheadquarters.models.User;
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
 * Created by Michal Kostewicz on 05.03.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataElasticsearchConfigForTest.class})
public class UserServiceTest {
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    UserService userService;

    @Before
    public void setUp() throws InterruptedException {
        Thread.sleep(100);
        userService.save(new User(null, "Sam", "NY", "sam@abc.com"));
        userService.save(new User(null, "Tommy", "ALBAMA", "tomy@abc.com"));
        userService.save(new User(null, "Kelly", "NEBRASKA", "kelly@abc.com"));
    }

    @After
    public void clearData() {
        userService.deleteAll();
    }

    @Test
    public void findAllUsersTest() {
        Set<User> usersFounded = userService.findAllEntities();
        Assert.assertNotNull(usersFounded);
        Assert.assertEquals(3, usersFounded.size());
    }

    @Test
    public void findByIdTest() {
        User userFounded = userService.findById(3L);
        Assert.assertNotNull(userFounded);
        Assert.assertEquals(Long.valueOf(3), userFounded.getId());
    }

    @Test
    public void findByNameTest() {
        User userFounded = userService.findByName("Tommy").get(0);
        Assert.assertNotNull(userFounded);
        Assert.assertEquals("Tommy", userFounded.getName());
    }

    @Test
    public void saveUserTest() {
        User newUser = new User(null, "Johny", "BRAVO", "johnny@abc.com");
        userService.save(newUser);

        User userFounded = userService.findByName("Johny").get(0);
        Assert.assertNotNull(userFounded);
        Assert.assertEquals(newUser, userFounded);
    }

    @Test
    public void updateUserTest() {
        User userForUpdate = userService.findById(3L);
        userForUpdate.setName("Richard");
        userService.updateEnity(userForUpdate);

        List<User> userNotFounded = userService.findByName("Kelly");
        Assert.assertEquals(new ArrayList(), userNotFounded);

        User userFounded = userService.findByName("Richard").get(0);
        Assert.assertEquals(userForUpdate, userFounded);
    }

    @Test
    public void deleteUserByIdTest() {
        User userForDelete = userService.findById(3L);
        Assert.assertNotNull(userForDelete);

        userService.deleteEntityById(3L);
        User userDeleted = userService.findById(3L);
        Assert.assertNull(userDeleted);
    }

    @Test
    public void isUserExistTest() {
        User existingUser = userService.findById(1L);
        Assert.assertNotNull(existingUser);

        boolean userExist = userService.isEntityExist(existingUser);
        Assert.assertEquals(true, userExist);
    }

    @Test
    public void findNewMaxIdTest() {
        Long maxId = userService.findNewMaxId();
        Assert.assertEquals(Long.valueOf(4), maxId);
    }
}
