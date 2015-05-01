package com.nuzbox.tasks.tasks;

import java.util.HashMap;

/**
 * Created by Farrell on 01/05/2015.
 */
public class FetchLatestArticlesTask implements CronJobPerformableInterface {
    @Override
    public void run() {

    }

    @Override
    public void init() {
        run();
    }

    @Override
    public void setParameters(HashMap<String, ?> parameters) {

    }
}
