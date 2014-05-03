package org.codetrials.bundle.engines;

public class JavaScriptEngine extends StandardEngine {

    public JavaScriptEngine() {
        super("nashorn");
    }

    protected boolean updateBalance(String command) {
        command = command.substring(0, (command + "//").indexOf("//"));
        boolean insideString = false;
        char stringType = 0;
        for (int i = 0; i < command.length(); ++i) {
            if (command.charAt(i) == '\'' || command.charAt(i) == '"') {
                if (!insideString) {
                    insideString = true;
                    stringType = command.charAt(i);
                } else if (insideString && stringType == command.charAt(i)) {
                    insideString = false;
                }
            } else if (command.charAt(i) == '{' && !insideString) {
                balance++;
            } else if (command.charAt(i) == '}' && !insideString) {
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
