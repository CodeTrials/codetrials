package org.codetrials.bundle.common;

/**
 * @author Polyarnyi Nikolay
 */
public class CommandOutput {

    private final String hint;
    private final String executionOutput;
    private final String exceptionOutput;

    public CommandOutput(String hint, String executionOutput, String exceptionOutput) {
        this.hint = hint;
        this.executionOutput = executionOutput;
        this.exceptionOutput = exceptionOutput;
    }

    public String getHint() {
        return hint;
    }

    public String getExecutionOutput() {
        return executionOutput;
    }

    public String getExceptionOutput() {
        return exceptionOutput;
    }

    @Override
    public String toString() {
        return executionOutput + "\n" +
                "Hint: " + hint + "\n" +
                "Exception: " + exceptionOutput;
    }
}
