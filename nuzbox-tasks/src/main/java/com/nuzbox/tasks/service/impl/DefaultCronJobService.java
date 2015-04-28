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
        Collection<CronJobModel> cronJobs = modelService.<CronJobModel>getAll();

        LOG.info("Look at me, I got some jobs...");
        for (CronJobModel cronJob : cronJobs) {
            LOG.info(cronJob.getId());
            LOG.info(cronJob.getSomeOtherShit());
            LOG.info(cronJob.getEvenMoreShit());
            LOG.info(cronJob.getYetMoreShit());
        }
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
