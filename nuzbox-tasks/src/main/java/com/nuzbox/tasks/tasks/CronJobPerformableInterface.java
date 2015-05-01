package com.nuzbox.tasks.tasks;

import java.util.HashMap;

/**
 * Created by Farrell on 01/05/2015.
 */
public interface CronJobPerformableInterface {

    public void init();

    public void run();

    public void setParameters(HashMap<String,?> parameters);

}
