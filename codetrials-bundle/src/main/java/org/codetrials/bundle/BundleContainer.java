package org.codetrials.bundle;

import org.codetrials.bundle.entities.CommandOutput;
import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.entities.TaskReaction;

/**
 * @author Polyarnyi Nikolay
 */
public abstract class BundleContainer {

    public CommandOutput processCommand(String command) {
        Task currentTask = getCurrentTask();
        TaskReaction reaction;
        ExecutionResult executionResult;
        if (currentTask.isCommandExecutable(command)) {
            executionResult = executeCommand(command);
            if (executionResult != null) {
                reaction = currentTask.onCommandExecuted(command, executionResult);
                if (currentTask.isCompleted()) {
                    moveToNextTask();
                }
                return new CommandOutput(reaction, executionResult);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public abstract String getBundleName();

    public abstract String getBundleDescription();

    public abstract Task getCurrentTask();

    protected abstract void moveToNextTask();

    protected abstract ExecutionResult executeCommand(String command);


}
