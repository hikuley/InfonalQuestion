package com.infonal.controller.impl;

import com.infonal.controller.inf.UserRestInf;
import com.infonal.model.request.UserRequest;
import com.infonal.model.response.UserResponse;
import com.infonal.services.inf.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by hikuley on 21.08.2015.
 */
@Controller
@RequestMapping("/userRest")
public class UserRestImpl implements UserRestInf {

    @Autowired
    public UserService userService;

    @Override
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public UserResponse create(@RequestBody UserRequest request) {
        return userService.create(request);
    }

    @Override
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public UserResponse update(@RequestBody UserRequest request) {
        return userService.update(request);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public UserResponse delete(@PathVariable String id) {
        return userService.delete(id);
    }

    @Override
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public UserResponse findById(@PathVariable String id) {
        return userService.findById(id);
    }
}
