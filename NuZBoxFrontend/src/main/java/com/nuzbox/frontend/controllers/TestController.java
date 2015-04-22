package com.nuzbox.frontend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

/**
 * Created by Jamesjohnstone on 22/04/15.
 */
@Controller
public class TestController {

    static Logger log = Logger.getLogger(TestController.class.getName());
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        log.info("I am being run!");
        String test = "Test";
        model.addAttribute("testMessage", test);
        return "index";
    }

}
