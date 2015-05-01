package com.nuzbox.tasks.tasks.exceptions;

import com.nuzbox.exceptions.NuzboxBaseLoggedException;

/**
 * Created by Farrell on 01/05/2015.
 */
public class CronJobPerformableException extends NuzboxBaseLoggedException {

    public CronJobPerformableException(String message) { super(message); }
    public CronJobPerformableException(String message, Throwable cause) { super(message,cause); }
}
