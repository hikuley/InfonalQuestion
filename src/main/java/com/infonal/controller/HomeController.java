package com.infonal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hikuley on 21.08.2015.
 */
@Controller
@RequestMapping("/")
public class HomeController {

    public static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {
        logger.info("Home page loaded");
        return "home";
    }
}
