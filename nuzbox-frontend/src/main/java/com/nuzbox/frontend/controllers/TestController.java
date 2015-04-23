package com.nuzbox.frontend.controllers;

import com.nuzbox.model.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.log4j.Logger;

/**
 * Created by Jamesjohnstone on 22/04/15.
 */
@Controller
public class TestController {
    @Autowired
    private ModelService modelService;

    private static final Logger LOG = Logger.getLogger(TestController.class);

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String printHello(ModelMap model, @RequestParam String echo) {
        LOG.info("I am being run!");
        modelService.save(null);
        String test = "Test";
        model.addAttribute("testMessage", test);
        model.addAttribute("youPutIn", echo);
        return "index";
    }
}