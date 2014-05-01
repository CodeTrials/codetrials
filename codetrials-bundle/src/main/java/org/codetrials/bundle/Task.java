package org.codetrials.bundle;

import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.entities.TaskDescription;
import org.codetrials.bundle.entities.TaskReaction;

/**
 * @author Polyarnyi Nikolay
 */
public interface Task {

    TaskDescription getDescription();

    boolean isCompleted();

    boolean isCommandExecutable(String command);

    TaskReaction onCommandExecuted(String command, ExecutionResult e);

}