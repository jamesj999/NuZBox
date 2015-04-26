package com.nuzbox.tasks;

import com.nuzbox.model.CronJobModel;
import com.nuzbox.model.service.ModelService;
import com.nuzbox.tasks.service.CronJobService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 24/04/15.
 */
public class TasksStartup implements Servlet {
    private static final Logger LOG = Logger.getLogger(TasksStartup.class);
    @Autowired
    private ModelService modelService;

    public void init(ServletConfig servletConfig) throws ServletException {
        if(modelService == null) {
            LOG.error("PISS");
        } else {
            LOG.error("SHIT");
        }
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {

    }
}
