package com.infonal.services.impl;

import com.infonal.dao.inf.UserDAO;
import com.infonal.entity.User;
import com.infonal.model.request.UserRequest;
import com.infonal.model.response.UserResponse;
import com.infonal.services.inf.UserService;
import com.infonal.util.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hikuley on 21.08.2015.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO dao;

    @Override
    public UserResponse create(UserRequest request) {
        UserResponse response = new UserResponse();
        User user = request.getUser();
        dao.create(user);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setDescription("Created user");
        return response;
    }

    @Override
    public UserResponse update(UserRequest request) {
        UserResponse response = new UserResponse();
        User user = request.getUser();
        dao.update(user);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setDescription("Updated user");
        return response;
    }

    @Override
    public UserResponse delete(String id) {
        UserResponse response = new UserResponse();
        dao.delete(id);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setDescription("Deleted user");
        return response;
    }

    @Override
    public UserResponse findById(String id) {
        UserResponse response = new UserResponse();
        User user = dao.findById(id);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setDescription("Read user");
        response.setUser(user);
        return response;
    }
}
