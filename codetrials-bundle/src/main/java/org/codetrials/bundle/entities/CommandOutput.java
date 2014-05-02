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

    public CommandOutput(TaskReaction reaction, ExecutionResult result) {
        this.reaction = reaction;
        this.result = result;
    }

    public TaskReaction getReaction() {
        return reaction;
    }

    public ExecutionResult getResult() {
        return result;
    }

}
