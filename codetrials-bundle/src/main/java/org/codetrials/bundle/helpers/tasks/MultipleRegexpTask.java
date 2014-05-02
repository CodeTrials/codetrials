package org.codetrials.bundle.helpers.tasks;

import org.codetrials.bundle.Task;
import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.entities.TaskDescription;
import org.codetrials.bundle.entities.TaskReaction;

/**
 * Usable in case, when you want ask user to play with set of simple functions, and then move to next slide at user request.
 *
 * @author Polyarnyi Nikolay
 */
public class MultipleRegexpTask extends Task {

    private final String[] regexps;
    private final String finishCommand;
    private final String hint;
    private boolean completed;

    /**
     * @param taskDescription for example title: "Math arithmetics"
     *                        for example description: "Try to repeat some math! Use some of this operations: 3 + 5, 2 - 1, 4 * 9.
     *                        When you will satisfied - enter "next" command."
     * @param hint            for example: "Try command: "5+3"! Or "next" - to move for next task!"
     * @param finishCommand   for example: "next"
     * @param commands        regexps for this task. For example: new String[]{".*\\+.*", ".*\\*.*", ".*-.*"}
     */
    public MultipleRegexpTask(TaskDescription taskDescription, String hint, String finishCommand, String... commands) {
        super(taskDescription);
        this.hint = hint;
        this.regexps = commands;
        this.finishCommand = finishCommand;
        this.completed = false;
    }

    @Override
    public boolean isCompleted() {
        return completed;
    }

    @Override
    public boolean isCommandExecutable(String command) {
        if (finishCommand.equals(command)) {
            return false;
        }
        for (String regexp : regexps) {
            if (command.matches(regexp)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public TaskReaction onCommandExecuted(String command, ExecutionResult e) {
        if (finishCommand.equals(command)) {
            this.completed = true;
            return new TaskReaction(true);
        }
        if (e.getException() != null) {
            return new TaskReaction(hint, true);
        }
        for (String regexp : regexps) {
            if (command.matches(regexp)) {
                return new TaskReaction(true);
            }
        }
        return new TaskReaction(hint, true);
    }
}
