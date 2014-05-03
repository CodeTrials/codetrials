package org.codetrials.bundle.engines;

/**
 * Created by vlpolyansky.
 */
public class PythonEngine extends StandardEngine {

    public PythonEngine() {
        super("jython");
    }

    protected boolean updateBalance(String command) {
        command = command.substring(0, (command + '#').indexOf('#'));
        if (command.trim().endsWith(":")) {
            balance++;
        } else if (command.trim().length() == 0) {
            balance = 0;
        }
        return true;
    }
}
