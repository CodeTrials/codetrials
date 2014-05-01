package org.codetrials.bundle.exceptions;

/**
 * @author Polyarnyi Nikolay
 */
public class CommandException extends Exception {

    public CommandException(String message) {
        super(message);
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
    }

}
