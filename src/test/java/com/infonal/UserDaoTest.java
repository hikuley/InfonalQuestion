package com.infonal;

import com.infonal.dao.inf.UserDAO;
import com.infonal.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by hikuley on 21.08.2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:com/infonal/config/applicationContext.xml")
public class UserDaoTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void createTest() {
        User user = new User();
        user.setName("Halil İbrahim");
        user.setSurname("Küley");
        user.setCellPhone("0541 948 55 99");
        user.setCitizenNumber("6454466");
        user.setEmail("ssoulless25@gmail.com");
        user.setWorkPhone("0541 987 26 24");
        user.setCitizenNumber("14948075266");
        userDAO.create(user);
    }

    @Test
    public void updateTest() {
        User user = new User();
        user.setId("55d74108b40fc1fd7ab35fb6");
        user.setName("Halil İbrahim3");
        user.setSurname("Küley2");
        user.setCellPhone("0541 948 55 552");
        user.setCitizenNumber("64544662");
        user.setEmail("ssoulless25@gmail.com2");
        user.setWorkPhone("0541 987 26 242");
        user.setCitizenNumber("149480752663");
        userDAO.update(user);
    }

    @Test
    public void deleteTest() {
        userDAO.delete("55d7179ab40f159e9b8d313e");
    }

    @Test
    public void findAllTest() {
        List<User> userList = userDAO.findAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    @Test
    public void findByIdTest() {
        User user = userDAO.findById("55d73d70b40fe92a9d8650b7");
        System.out.println(user.toString());
    }

}
