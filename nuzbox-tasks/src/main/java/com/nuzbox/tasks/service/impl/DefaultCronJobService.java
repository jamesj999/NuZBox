package com.nuzbox.tasks.service.impl;

import com.nuzbox.model.CronJobModel;
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
    private List<CronJobModel> jobs;

    @Autowired
    private ModelService modelService;

 //   private Scheduler scheduler;

    private static final Logger LOG = Logger.getLogger(DefaultCronJobService.class);

    @Override
    public void initializeCronJobs() {
        // Start Quartz:
//        try {
//            scheduler = StdSchedulerFactory.getDefaultScheduler();
//            scheduler.start();

            // Retrieve a list of CronJob instances:
            Collection<CronJobModel> cronJobs = modelService.<CronJobModel>getAll();

            for (CronJobModel cronJob : cronJobs) {
                // Get the trigger
                // Register the job with Quartz - might need conversion from model to some compatible object?
            }
//        } catch (SchedulerException e) {
//            LOG.error("There was a problem initializing task scheduler.", e);
//        }
    }

    @Override
    public void shutdownCronJobs() {
        // Stop quartz
//        try {
//            scheduler.shutdown();
//        } catch (SchedulerException e) {
//            LOG.error("Could not shutdown task scheduler.", e);
//        }
    }

}
