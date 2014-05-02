package org.codetrials.bundle.helpers.tasks;

import org.codetrials.bundle.Task;
import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.entities.TaskDescription;
import org.codetrials.bundle.entities.TaskReaction;

/**
 * Created by vlpolyansky.
 */
public class SandboxTask extends Task {

    public SandboxTask(int id) {
        super(new TaskDescription("Sandbox", "", id));
    }

    public SandboxTask(TaskDescription taskDescription) {
        super(taskDescription);
    }

    @Override
    public boolean isCompleted() {
        return false;
    }

    @Override
    public TaskReaction onCommandExecuted(String command, ExecutionResult e) {
        return new TaskReaction();
    }
}
