package com.nuzbox.tasks.service.impl;

import com.nuzbox.model.CronJobModel;
import com.nuzbox.tasks.service.CronJobService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by james on 24/04/15.
 */
public class DefaultCronJobService implements CronJobService {
    private List<CronJobModel> jobs;

    @Override
    public void initializeCronJobs() {
        System.out.println("piss\n\n\n\n\n\n\n\npiss");
        // Retrieve a list of CronJob instances:
        List<CronJobModel> cronJobs = new ArrayList<CronJobModel>();

        for(CronJobModel cronJob : cronJobs) {
            // Get the trigger
            // Register the job with Quartz - might need conversion from model to some compatible object?
        }
    }

}
