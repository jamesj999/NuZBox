package com.nuzbox.model.service.impl;

import com.nuzbox.dao.CronJobDAO;
import com.nuzbox.model.BaseModel;
import com.nuzbox.model.service.ModelService;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by james on 22/04/15.
 */
public class DefaultModelService implements ModelService {
    @Autowired
    CronJobDAO cronJobDAO;

    private final SessionFactory sessionFactory;

    private static final Logger LOG = Logger.getLogger(DefaultModelService.class);

    public DefaultModelService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    @Override
    public void save(BaseModel model) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(model);
            session.getTransaction().commit();
        } catch(HibernateException e) {
            LOG.error("There was a problem saving...", e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
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
