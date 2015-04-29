package com.nuzbox.model.service.impl;

import com.nuzbox.dao.CronJobDAO;
import com.nuzbox.model.BaseModel;
import com.nuzbox.model.service.ModelService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

/**
 * Created by james on 22/04/15.
 */
public class DefaultModelService implements ModelService {
    @Autowired
    CronJobDAO cronJobDAO;

    private static final Logger LOG = Logger.getLogger(DefaultModelService.class);

    @Override
    public void save(BaseModel model) {
        //TODO: DB wib wabbedy
        LOG.info("Doing some stuff");
    }

    @Override
    public BaseModel lookupByIdentity() {
        //TODO: DB wib wabbedy
        return null;
    }

    public <T extends BaseModel> Collection<T> getAll() {
        return (Collection<T>) cronJobDAO.getAllCronJobs();
    }
}
