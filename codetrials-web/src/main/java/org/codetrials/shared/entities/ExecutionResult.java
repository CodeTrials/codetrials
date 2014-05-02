package org.codetrials.shared.entities;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Polyarnyi Nikolay
 */
public class ExecutionResult implements IsSerializable {

    private String hint;
    private String output;
    private String error;
    private boolean isCommandFinished;

    private ExecutionResult() {
    }

    public ExecutionResult(String hint, String output, String error, boolean isCommandFinished) {
        this.hint = hint;
        this.output = output;
        this.error = error;
        this.isCommandFinished = isCommandFinished;
    }

    public String getHint() {
        return hint;
    }

    public String getOutput() {
        return output;
    }

    public String getError() {
        return error;
    }

    public boolean isCommandFinished() {
        return isCommandFinished;
    }
}
