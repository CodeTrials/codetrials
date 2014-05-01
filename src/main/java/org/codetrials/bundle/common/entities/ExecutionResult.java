package org.codetrials.bundle.common.entities;

import org.codetrials.bundle.common.exceptions.CommandException;

public class ExecutionResult {

    private String executionOutput;
    private CommandException exception;

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