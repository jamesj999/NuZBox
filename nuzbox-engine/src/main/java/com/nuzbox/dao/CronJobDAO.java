package com.nuzbox.dao;

import com.nuzbox.model.CronJob;

import java.util.Collection;

/**
 * Created by Jamesjohnstone on 28/04/15.
 */
public interface CronJobDAO {

    public Collection<CronJob> getAllCronJobs();
}
