package org.codetrials.bundle.entities;

import org.codetrials.bundle.exceptions.CommandException;

/**
 * Result of executing command.
 *
 * @author Polyarnyi Nikolay
 */
public class ExecutionResult {

    private final String executionOutput;
    private final CommandException exception;

    private ExecutionResult(String executionOutput, CommandException exception) {
        this.executionOutput = executionOutput;
        this.exception = exception;
    }

    public String getExecutionOutput() {
        return executionOutput;
    }

    public CommandException getException() {
        return exception;
    }
}