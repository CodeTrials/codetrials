package org.codetrials.server.exceptions;

/**
 * @author Polyarnyi Nikolay
 */
public class InvalidBundle extends Exception {

    public InvalidBundle() {
    }

    public InvalidBundle(String message) {
        super(message);
    }

    public InvalidBundle(String message, Throwable cause) {
        super(message, cause);
    }
}
