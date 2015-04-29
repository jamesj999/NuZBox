package com.nuzbox.dao.impl;

import com.nuzbox.dao.CronJobDAO;
import com.nuzbox.model.CronJob;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

/**
 * Created by Jamesjohnstone on 28/04/15.
 */
public class DefaultCronJobDAO implements CronJobDAO {
    private SessionFactory sessionFactory;

    public DefaultCronJobDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Collection<CronJob> getAllCronJobs() {
        @SuppressWarnings("unchecked")
        List<CronJob> cronJobs = (List<CronJob>) sessionFactory.getCurrentSession()
                .createCriteria(CronJob.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

        return cronJobs;
    }
}
