package com.nuzbox.tasks;

import com.nuzbox.model.service.ModelService;
import com.nuzbox.tasks.service.CronJobService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;


import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by james on 24/04/15.
 */
public class TasksStartup implements Servlet {
    // For some reason, the Autowire annotation doesn't work in this class, so we have to get the bean a funny way:
    private CronJobService cronJobService = (CronJobService) ApplicationContextProvider.getApplicationContext().getBean("cronJobService");

    private static final Logger LOG = Logger.getLogger(TasksStartup.class);

    private ServletConfig servletConfig;

    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;

        LOG.info("Starting CronJob Timers...");
        cronJobService.initializeCronJobs();
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

    }

    public String getServletInfo() {
        return servletConfig.getServletName();
    }

    public void destroy() {
        // Do we need to unload CronJob timers here?
        cronJobService.shutdownCronJobs();
    }
}
