package com.nuzbox.exceptions;

import org.apache.log4j.Logger;

/**
 * Created by Farrell on 01/05/2015.
 */
public abstract class NuzboxBaseLoggedException extends Exception {

    private final Logger LOG = Logger.getLogger(this.getClass());

    public NuzboxBaseLoggedException(String message) {
        super(message);
        LOG.error(message);
    }
    public NuzboxBaseLoggedException(String message, Throwable throwable) {
        super(message,throwable);
        LOG.error(message,throwable);
    }
}
