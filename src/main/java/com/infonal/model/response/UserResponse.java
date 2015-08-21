package com.infonal.model.response;

import com.infonal.entity.User;
import com.infonal.util.Response;

/**
 * Created by hikuley on 21.08.2015.
 */
public class UserResponse extends Response {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
