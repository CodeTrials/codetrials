package org.codetrials.bundle.common;

import org.codetrials.bundle.common.exceptions.CommandException;

/**
 * @author Polyarnyi Nikolay
 */
public interface Task {

    String getTitle();

    String getDescription();

    TaskReaction onCommandEntered(String command);

    String onCommandException(CommandException e);

    boolean isCompleted();

    boolean isCommandExecutable(String command);

    String onCommandExecuted(String command, String executionOutput);

}
