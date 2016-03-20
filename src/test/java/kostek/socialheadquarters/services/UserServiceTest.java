package kostek.socialheadquarters.services;

import kostek.socialheadquarters.config.SpringDataElasticsearchConfigForTest;
import kostek.socialheadquarters.config.WebConfig;
import org.junit.*;
import kostek.socialheadquarters.models.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
    public void setUp() {
        userService.saveUser(new User(1L, "Sam", "NY", "sam@abc.com"));
        userService.saveUser(new User(2L, "Tommy", "ALBAMA", "tomy@abc.com"));
        userService.saveUser(new User(3L, "Kelly", "NEBRASKA", "kelly@abc.com"));
    }

    @After
    public void clearData(){
        elasticsearchTemplate.deleteIndex(User.class);
        //userService.deleteAll();
    }

    @Test
    public void findAllUsersTest() {
        Set<User> usersFounded = userService.findAllUsers();
        Assert.assertNotNull(usersFounded);
        Assert.assertEquals(3 , usersFounded.size());
    }

    @Test
    public void findByIdTest() {
        User userFounded = userService.findById(3L);
        Assert.assertNotNull(userFounded);
        Assert.assertEquals(Long.valueOf(3) , userFounded.getId());
    }

    @Test
    public void findByNameTest() {
        User userFounded = userService.findByName("Tommy").get(0);
        Assert.assertNotNull(userFounded);
        Assert.assertEquals("Tommy" , userFounded.getName());
    }

    @Test
    public void saveUserTest() {
        User newUser = new User(4L, "Johny", "BRAVO", "johnny@abc.com");
        userService.saveUser(newUser);

        User userFounded = userService.findByName("Johny").get(0);
        Assert.assertNotNull(userFounded);
        Assert.assertEquals(newUser, userFounded);
    }

    @Test
    public void updateUserTest() {
        User userForUpdate = userService.findById(3L);
        userForUpdate.setName("Richard");
        userService.updateUser(userForUpdate);

        List<User> userNotFounded = userService.findByName("Kelly");
        Assert.assertEquals(new ArrayList(), userNotFounded);

        User userFounded = userService.findByName("Richard").get(0);
        Assert.assertEquals(userForUpdate, userFounded);
    }

    @Test
    public void deleteUserByIdTest() {
        User userForDelete = userService.findById(3L);
        Assert.assertNotNull(userForDelete);

        userService.deleteUserById(3L);
        User userDeleted = userService.findById(3L);
        Assert.assertNull(userDeleted);
    }

    @Test
    public void isUserExistTest() {
        User existingUser = userService.findById(1L);
        Assert.assertNotNull(existingUser);

        boolean userExist = userService.isUserExist(existingUser);
        Assert.assertEquals(true , userExist);
    }

    @Test
    public void findMaxIdTest(){
        Long maxId = userService.findMaxId();
        Assert.assertEquals(Long.valueOf(3), maxId);
    }
}
