package org.codetrials.bundle.helpers.tasks;

import org.codetrials.bundle.Task;
import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.entities.TaskDescription;
import org.codetrials.bundle.entities.TaskReaction;

/**
 * Created by vlpolyansky.
 */
public class FreeTask extends Task {

    private final String finishCommand;
    private boolean completed;

    public FreeTask(TaskDescription taskDescription, String finishCommand) {
        super(taskDescription);
        this.finishCommand = finishCommand;
        this.completed = false;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public TaskReaction onCommandExecuted(String command, ExecutionResult e) {
        if (finishCommand.equals(command)) {
            this.completed = true;
            return new TaskReaction(true);
        }
        return new TaskReaction(false);
    }
}
