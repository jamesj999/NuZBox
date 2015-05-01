package com.nuzbox.frontend.controllers;

import com.nuzbox.model.service.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.nntp.NNTPClient;
import org.apache.commons.net.nntp.NewsgroupInfo;


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.PrintWriter;

/**
 * Created by Jamesjohnstone on 22/04/15.
 */
@Controller
public class TestController {
    @Autowired
    private ModelService modelService;

    private static final Logger LOG = Logger.getLogger(TestController.class);

    @RequestMapping(value = {"/", "/index**"}, method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        LOG.info("I am being run!");

        String hostname = "x";
        String username = "y";
        String password = "z";

        try {
            NNTPClient client = new NNTPClient();
            client.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out), true));
            client.connect(hostname);
            client.authenticate(username, password);


            NewsgroupInfo group = new NewsgroupInfo();
            client.selectNewsgroup("alt.binaries.hdtv.x264",group);

            BufferedReader br;
            String line;
            long articleNum = group.getLastArticleLong();
            br = client.retrieveArticleHeader(articleNum);

            StringBuffer buffer = new StringBuffer();
            if (br != null) {
                while ((line = br.readLine()) != null) {
                    LOG.info(line);
                    buffer.append(line);
                }
                model.addAttribute("article",buffer.toString());
            }
            br.close();

        }
        catch (Exception ignore ){}


        String test = "Test";
        model.addAttribute("testMessage", test);
        return "index";
    }

    @RequestMapping(value= "/echo**", method = RequestMethod.GET)
    public String echo(ModelMap model, @RequestParam String echo) {
        model.addAttribute("youPutIn", echo);
        return "echo";
    }

}