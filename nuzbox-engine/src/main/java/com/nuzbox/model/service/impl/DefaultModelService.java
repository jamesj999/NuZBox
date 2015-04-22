package com.nuzbox.model.service.impl;

import com.nuzbox.model.AbstractModel;
import com.nuzbox.model.service.ModelService;
import com.nuzbox.persistence.service.HibernateService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by james on 22/04/15.
 */
public class DefaultModelService implements ModelService {
    @Autowired
    private HibernateService hibernateService;

    private static final Logger LOG = Logger.getLogger(DefaultModelService.class);

    public void save(AbstractModel model) {
        //TODO: DB wib wabbedy
        LOG.info("Doing some stuff");
    }

    public AbstractModel getById() {
        //TODO: DB wib wabbedy
        return null;
    }
}
