package org.codetrials.bundle.common;

import org.codetrials.bundle.common.entities.ExecutionResult;
import org.codetrials.bundle.common.entities.TaskDescription;
import org.codetrials.bundle.common.exceptions.CommandException;

/**
 * @author Polyarnyi Nikolay
 */
public interface Task {

    TaskDescription getDescription();

    boolean isCompleted();

    boolean isCommandExecutable(String command);

    String onCommandExecuted(ExecutionResult e);

}
