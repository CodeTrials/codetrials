package org.codetrials.bundle;

import org.codetrials.bundle.engines.BundleEngine;
import org.codetrials.bundle.entities.CommandOutput;
import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.entities.TaskDescription;
import org.codetrials.bundle.entities.TaskReaction;

/**
 * @author Polyarnyi Nikolay
 */
public abstract class BundleContainer {

    private BundleEngine engine;

    protected BundleContainer(BundleEngine engine) {
        this.engine = engine;
    }

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
            reaction = currentTask.onCommandExecuted(command, null);
            if (currentTask.isCompleted()) {
                moveToNextTask();
            }
            return new CommandOutput(reaction, null);
        }
    }

    public abstract String getBundleName();

    public abstract String getBundleDescription();

    public TaskDescription getTaskDescription() {
        return getCurrentTask().getDescription();
    }

    public abstract int getCurrentStepNumber();

    public abstract int getTotalStepsCount();

    protected abstract Task getCurrentTask();

    protected abstract void moveToNextTask();

    protected ExecutionResult executeCommand(String command) {
        return engine.exec(command);
    }


}
