package org.codetrials.server.exceptions;

/**
 * @author Polyarnyi Nikolay
 */
public class InvalidBundleException extends Exception {

    public InvalidBundleException() {
    }

    public InvalidBundleException(String message) {
        super(message);
    }

    public InvalidBundleException(String message, Throwable cause) {
        super(message, cause);
    }
}
