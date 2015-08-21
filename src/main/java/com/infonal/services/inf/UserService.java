package com.infonal.services.inf;

import com.infonal.model.request.UserRequest;
import com.infonal.model.response.UserResponse;

/**
 * Created by hikuley on 21.08.2015.
 */
public interface UserService {

    UserResponse create(UserRequest request);

    UserResponse update(UserRequest request);

    UserResponse delete(String id);

    UserResponse findById(String id);

}
