package org.codetrials.bundle.entities;

/**
 * Task reaction for executed command. Contains nullable hint, that task want to tell user as reaction for his input.
 *
 * @author Polyarnyi Nikolay
 */
public class TaskReaction {

    private final String hint;

    public TaskReaction() {
        this(null);
    }

    public TaskReaction(String hint) {
        this.hint = hint;
    }

    public String getHint() {
        return hint;
    }
}
