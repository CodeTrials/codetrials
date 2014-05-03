package org.codetrials.bundle.engines;

import java.util.Arrays;

/**
 * Created by vlpolyansky.
 */
public class PythonEngine extends StandardEngine {

    public PythonEngine() {
        super("jython");
    }

    protected boolean updateBalance(String command) {
        System.err.println("line: '" + command + "' len = " + command.length() + " bytes = "
        + Arrays.toString(command.getBytes()));
        if (command.trim().endsWith(":")) {
            balance++;
        } else if (command.trim().length() == 0) {
            balance = 0;
        }
        return true;
    }
}
