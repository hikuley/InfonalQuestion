package com.infonal.dao.inf;

import com.infonal.entity.User;

import java.util.List;

/**
 * Created by hikuley on 21.08.2015.
 */
public interface UserDAO {

    void create(User user);

    void update(User user);

    Long delete(String id);

    List<User> findAll();

    User findById(String id);

}
