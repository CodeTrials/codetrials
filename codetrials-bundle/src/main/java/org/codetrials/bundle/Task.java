package org.codetrials.bundle;

import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.entities.TaskDescription;

/**
 * @author Polyarnyi Nikolay
 */
public interface Task {

    TaskDescription getDescription();

    boolean isCompleted();

    boolean isCommandExecutable(String command);

    String onCommandExecuted(ExecutionResult e);

}
