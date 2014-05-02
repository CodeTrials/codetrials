package org.codetrials.bundle.helpers.tasks;

import org.codetrials.bundle.Task;
import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.entities.TaskDescription;
import org.codetrials.bundle.entities.TaskReaction;

/**
 * @author Polyarnyi Nikolay
 */
public class SingleRegexpTask extends Task {

    private final String regexp;
    private boolean completed;

    public SingleRegexpTask(TaskDescription taskDescription, String regexp) {
        super(taskDescription);
        this.regexp = regexp;
        this.completed = false;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean isCommandExecutable(String command) {
        return command.matches(regexp);
    }

    @Override
    public TaskReaction onCommandExecuted(String command, ExecutionResult e) {
        if ((e == null || e.getException() == null) && command.matches(regexp)) {
            this.completed = true;
        }
        return new TaskReaction();
    }
}
