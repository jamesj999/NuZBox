package com.nuzbox.admin.editors.exception;

/**
 * Created by Jamesjohnstone on 01/05/15.
 */
public abstract class EditorException extends Exception {
        // pass that shit up the chain

        public EditorException(String message) {
            super(message);
        }

        public EditorException(Throwable cause) {
            super(cause);
        }

        public EditorException(String message, Throwable cause) {
            super(cause);
        }

    }
