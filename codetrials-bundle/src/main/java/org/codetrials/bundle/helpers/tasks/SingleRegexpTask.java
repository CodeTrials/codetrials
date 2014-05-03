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
    private String hint;

    public SingleRegexpTask(TaskDescription taskDescription, String regexp) {
        this(taskDescription, regexp, null);
    }

    public SingleRegexpTask(TaskDescription taskDescription, String regexp, String hint) {
        super(taskDescription);
        this.regexp = regexp;
        this.completed = false;
        this.hint = hint;
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
        return new TaskReaction(this.completed ? null : hint);
    }
}
