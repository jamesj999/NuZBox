package com.nuzbox.frontend.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by james on 23/04/15.
 */
@Controller
public class ProfilePageController {
    private static final Logger LOG = Logger.getLogger(AdminPageController.class);

    @RequestMapping(value = "/profile**", method = RequestMethod.GET)
    public String profileHome(ModelMap model) {
        return "profile";
    }
}