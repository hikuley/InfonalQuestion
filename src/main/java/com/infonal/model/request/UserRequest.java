package com.infonal.model.request;

import com.infonal.entity.User;
import com.infonal.util.Request;

/**
 * Created by hikuley on 21.08.2015.
 */
public class UserRequest extends Request {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
