package org.codetrials.shared.entities;

/**
 * @author Nikita Zyulyaev
 */
public class UploadResult {
    private final boolean success;
    private final String message;
    private final Trial newTrial;

    public UploadResult(boolean success, String message, Trial newTrial) {
        this.success = success;
        this.message = message;
        this.newTrial = newTrial;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public Trial getNewTrial() {
        return newTrial;
    }
}
