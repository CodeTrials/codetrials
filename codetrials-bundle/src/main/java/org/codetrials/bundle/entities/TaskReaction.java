package org.codetrials.bundle.entities;

/**
 * Task reaction for executed command. Contains nullable hint, that task want to tell user as reaction for his input.
 *
 * @author Polyarnyi Nikolay
 */
public class TaskReaction {

    private final String hint;
    private final boolean isCommandFinished;

    public TaskReaction(boolean isCommandFinished) {
        this(null, isCommandFinished);
    }

    public TaskReaction(String hint, boolean isCommandFinished) {
        this.hint = hint;
        this.isCommandFinished = isCommandFinished;
    }

    public String getHint() {
        return hint;
    }

    public boolean isCommandFinished() {
        return isCommandFinished;
    }
}
