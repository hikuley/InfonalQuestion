package com.infonal;

import com.infonal.dao.inf.UserDAO;
import com.infonal.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

}
