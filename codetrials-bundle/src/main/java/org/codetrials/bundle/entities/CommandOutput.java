package org.codetrials.bundle.entities;

/**
 * Command output, that contain reaction of teaching environment, execution result and execution exception - runtime
 * or compile time.
 *
 * @author Polyarnyi Nikolay
 */
public class CommandOutput {

    private final TaskReaction reaction;
    private final ExecutionResult result;
    private final boolean isCommandFinished;

    public CommandOutput(TaskReaction reaction, ExecutionResult result, boolean isCommandFinished) {
        this.reaction = reaction;
        this.result = result;
        this.isCommandFinished = isCommandFinished;
    }

    public TaskReaction getReaction() {
        return reaction;
    }

    public ExecutionResult getResult() {
        return result;
    }

    public boolean isCommandFinished() {
        return isCommandFinished;
    }
}
