package org.codetrials.bundle.common.entities;

/**
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

    @Override
    public String toString() {
        return result.getExecutionOutput() + "\n" +
                "Hint: " + reaction.getHint() + "\n" +
                "Exception: " + result.getException().getMessage();
    }
}
