package com.nuzbox.dao;

import com.nuzbox.model.CronJobModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by Jamesjohnstone on 28/04/15.
 */
public interface CronJobDAO {

    public Collection<CronJobModel> getAllCronJobs();
}
