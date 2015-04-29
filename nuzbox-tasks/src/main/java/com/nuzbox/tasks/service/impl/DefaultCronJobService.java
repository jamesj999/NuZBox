package com.nuzbox.tasks.service.impl;

import com.nuzbox.model.CronJob;
import com.nuzbox.model.service.ModelService;
import com.nuzbox.tasks.service.CronJobService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.List;

/**
 * Created by james on 24/04/15.
 */
public class DefaultCronJobService implements CronJobService {
    private List<CronJob> jobs;

    @Autowired
    private ModelService modelService;

    //   private Scheduler scheduler;

    private static final Logger LOG = Logger.getLogger(DefaultCronJobService.class);

    @Override
    public void initializeCronJobs() {

        // Initialize those shits
    }

    @Override
    public void shutdownCronJobs() {
        // I guess we need to check if any are running and... wait? I dunno lol.
    }

}
