package org.codetrials.bundle.exceptions;

/**
 * Can be used to uniformly signalize runtime and compile time exceptions.
 *
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
