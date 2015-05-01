package com.nuzbox.tasks.service.impl;

import com.nuzbox.model.CronJob;
import com.nuzbox.model.service.ModelService;
import com.nuzbox.tasks.service.CronJobService;
import com.nuzbox.tasks.tasks.CronJobPerformableInterface;
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

        Collection<CronJob> cronJobs = modelService.getAll();

        for (CronJob cronJob : cronJobs) {
            String performableClass = cronJob.getPerformableClass();
            try {
                if (!performableClass.trim().isEmpty()) {
                    Class<?> cfi = Class.forName(performableClass);
                    CronJobPerformableInterface cjp = (CronJobPerformableInterface) cfi.newInstance();

                    //TODO schedule this badboy
                    cjp.init();
                }
            }
            catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
                LOG.error("Could not instantiate performable",e);
            }
        }
    }

    @Override
    public void shutdownCronJobs() {
        // I guess we need to check if any are running and... wait? I dunno lol.
    }

}
