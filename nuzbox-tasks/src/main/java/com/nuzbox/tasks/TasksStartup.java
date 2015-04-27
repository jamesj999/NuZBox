package com.nuzbox.tasks;

import com.nuzbox.model.service.ModelService;
import org.apache.log4j.Logger;


import javax.servlet.*;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by james on 24/04/15.
 */
public class TasksStartup implements Servlet {
    private static final Logger LOG = Logger.getLogger(TasksStartup.class);
    private ModelService modelService = (ModelService) ApplicationContextProvider.getApplicationContext().getBean("modelService");

    public void init(ServletConfig servletConfig) throws ServletException {
        LOG.warn("ModelService: "+modelService);

        String parameterNames = "";
        Enumeration<String> paramNames = servletConfig.getInitParameterNames();
        while(paramNames.hasMoreElements()) {
            parameterNames = parameterNames + ", " + paramNames.nextElement();
        }

        String attributeNames = "";
        Enumeration<String> attNames = servletConfig.getServletContext().getAttributeNames();
        while(attNames.hasMoreElements()) {
            attributeNames = attributeNames + ", " + attNames.nextElement();
        }

        LOG.info(parameterNames);
        LOG.info(attributeNames);
        LOG.info(servletConfig.getServletName());
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
