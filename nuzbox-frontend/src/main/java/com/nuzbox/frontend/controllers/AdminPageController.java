package com.nuzbox.frontend.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by james on 23/04/15.
 */

@Controller
public class AdminPageController {

    private static final Logger LOG = Logger.getLogger(AdminPageController.class);

    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
    public String adminHome(ModelMap model) {
        return "admin";
    }
}
