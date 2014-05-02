package org.codetrials.bundle.engines;

import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.exceptions.CommandException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class JavaScriptEngine implements BundleEngine {

    private ScriptEngine engine;
    private ByteArrayOutputStream buffer;
    private PrintStream bufferPrintStream;
    private int balance;

    private ByteArrayOutputStream commandOutput;
    private PrintStream commandPrintStream = new PrintStream(commandOutput);

    private static final PrintStream stdout = System.out;

    public JavaScriptEngine() {
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("nashorn");

        buffer = new ByteArrayOutputStream();
        bufferPrintStream = new PrintStream(buffer);
        balance = 0;

        commandOutput = new ByteArrayOutputStream();
        commandPrintStream = new PrintStream(commandOutput);
    }

    @Override
    public ExecutionResult exec(String command) {
        boolean balanceOK = updateBalance(command);
        if (!balanceOK) {
            reset();
            return new ExecutionResult(null, new CommandException("Wrong brace sequence"));
        }
        bufferPrintStream.println(command);
        bufferPrintStream.flush();
        if (balance == 0) {
            try {
                System.setOut(commandPrintStream);
                engine.eval(buffer.toString()); // returned value is ignored
                System.setOut(stdout);
                String ret = commandOutput.toString();
                reset();
                return new ExecutionResult(ret, null);
            } catch (ScriptException ex) {
                String ret = commandOutput.toString();
                reset();
                return new ExecutionResult(ret, new CommandException(ex.getMessage(), ex));
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

    private void reset() {
        buffer.reset();
        commandOutput.reset();
        balance = 0;
    }
}
