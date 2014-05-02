package org.codetrials.bundle.engines;

import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.exceptions.CommandException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;


public class JavaScriptEngine implements BundleEngine {

    private ScriptEngine engine;
    private ByteArrayOutputStream buffer;
    private PrintWriter pw;
    private int balance;

    public JavaScriptEngine() {
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("nashorn");

        buffer = new ByteArrayOutputStream();
        pw = new PrintWriter(buffer);
        balance = 0;
    }

    @Override
    public ExecutionResult exec(String command) {
        boolean balanceOK = updateBalance(command);
        if (!balanceOK) {
            return new ExecutionResult(null, new CommandException("Wrong brace sequence"));
        }
        pw.println(command);
        pw.flush();
        if (balance == 0) {
            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            try {
                PrintStream stdout = System.out;
                PrintStream ps = new PrintStream(bout);
                System.setOut(ps);
                engine.eval(buffer.toString()); // returned value is ignored
                System.setOut(stdout);
                buffer.reset();
                return new ExecutionResult(bout.toString(), null);
            } catch (ScriptException ex) {
                return new ExecutionResult(bout.toString(), new CommandException(ex.getMessage(), ex));
            }
        } else {
            return null;
        }
    }

    private boolean updateBalance(String command) {
        for (int i = 0; i < command.length(); ++i) {
            if (command.charAt(i) == '{') {
                balance++;
            } else if (command.charAt(i) == '}') {
                if (balance == 0) {
                    buffer.reset();
                    return false;
                } else {
                    balance--;
                }
            }
        }
        return true;
    }
}
