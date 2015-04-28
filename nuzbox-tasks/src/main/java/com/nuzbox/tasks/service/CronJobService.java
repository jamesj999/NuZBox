package com.nuzbox.tasks.service;

/**
 * Created by james on 24/04/15.
 */
public interface CronJobService {

    public void initializeCronJobs();

    public void shutdownCronJobs();

}
