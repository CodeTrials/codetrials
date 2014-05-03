package org.codetrials.bundle.engines;

public class JavaScriptEngine extends StandardEngine {

    public JavaScriptEngine() {
        super("nashorn");
    }

    protected boolean updateBalance(String command) {
        boolean insideComment = false;
        for (int i = 0; i < command.length(); ++i) {
            if (command.charAt(i) == '{') {
                balance++;
            } else if (command.charAt(i) == '}') {
                if (balance == 0) {
                    return false;
                } else {
                    balance--;
                }
            }
        }
        return true;
    }

}
