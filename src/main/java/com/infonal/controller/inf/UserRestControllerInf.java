package com.infonal.controller.inf;

import com.infonal.model.request.UserRequest;
import com.infonal.model.response.UserFindAllResponse;
import com.infonal.model.response.UserResponse;

/**
 * Created by hikuley on 21.08.2015.
 */
public interface UserRestControllerInf {

    UserResponse create(UserRequest request);

    UserResponse update(UserRequest request);

    UserResponse delete(String id);

    UserResponse findById(String id);

    UserFindAllResponse findAll();


}