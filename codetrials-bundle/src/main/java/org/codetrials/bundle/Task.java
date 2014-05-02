package org.codetrials.bundle;

import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.entities.TaskDescription;
import org.codetrials.bundle.entities.TaskReaction;

/**
 * @author Polyarnyi Nikolay
 */
public abstract class Task {

    private final TaskDescription taskDescription;

    protected Task(TaskDescription taskDescription) {
        this.taskDescription = taskDescription;
    }

    public TaskDescription getDescription() {
        return taskDescription;
    }

    public abstract boolean isCompleted();

    public int getID() {
        return taskDescription.getID();
    }

    /**
     * Can be overriden to interpret some user input as commands to task - NOT as language command. For example "next"
     * to move to next step. This possibility can be used to improve interactivity with current task.
     * @param command command, that should be checked
     * @return true, if command must be executed as language instruction. Or false, if command is to signalize smth to task.
     */
    public boolean isCommandExecutable(String command) {
        return true;
    }

    public abstract TaskReaction onCommandExecuted(String command, ExecutionResult e);

}