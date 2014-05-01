package org.codetrials.bundle.common;

import org.codetrials.bundle.common.exceptions.CommandException;

import java.util.List;

/**
 * @author Polyarnyi Nikolay
 */
public abstract class BundleContainer {

    public CommandOutput processCommand(String command) {
        Task currentTask = getCurrentTask();
        String reaction;
        String executionOutput = null;
        String exceptionOutput = null;
        if (currentTask.isCommandExecutable(command)) {
            try {
                executionOutput = executeCommand(command);// TODO: NOT WORK CE/RE ex
                reaction = currentTask.onCommandExecuted(command, executionOutput);
            } catch (CommandException e) {
                exceptionOutput = e.getMessage();
                reaction = currentTask.onCommandException(e);
            }
        } else {
            reaction = null;
        }
        if (currentTask.isCompleted()) {
            moveToNextTask();
        }
        return new CommandOutput(reaction, executionOutput, exceptionOutput);
    }

    public abstract String getBundleName();

    public abstract String getBundleDescription();

    public abstract Task getCurrentTask();

    protected void moveToNextTask() {

    }

    protected abstract String executeCommand(String command) throws CommandException;

}
