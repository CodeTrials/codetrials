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
        TaskReaction reaction = null;
        ExecutionResult executionResult = null;
        if (currentTask.isCommandExecutable(command)) {
            executionResult = executeCommand(command);
        }
        reaction = currentTask.onCommandExecuted(command, executionResult);
        if (currentTask.isCompleted()) {
            moveToNextTask();
        }
        return new CommandOutput(reaction, executionResult);
    }

    public abstract String getBundleName();

    public abstract String getBundleDescription();

    public abstract Task getCurrentTask();

    protected abstract void moveToNextTask();

    protected abstract ExecutionResult executeCommand(String command);


}
