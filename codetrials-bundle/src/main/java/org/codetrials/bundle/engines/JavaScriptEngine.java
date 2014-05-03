package org.codetrials.bundle.engines;

import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.exceptions.CommandException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;


public class JavaScriptEngine extends BundleEngine {

    private ScriptEngine engine;
    private ByteArrayOutputStream buffer;
    private PrintStream bufferPrintStream;
    private int balance;

    private ByteArrayOutputStream commandOutput;
    private PrintWriter commandPrintWriter;

    public JavaScriptEngine() {
        ScriptEngineManager factory = new ScriptEngineManager();
        engine = factory.getEngineByName("nashorn");

        buffer = new ByteArrayOutputStream();
        bufferPrintStream = new PrintStream(buffer);
        balance = 0;

        commandOutput = new ByteArrayOutputStream();
        commandPrintWriter = new PrintWriter(commandOutput);

        engine.getContext().setWriter(commandPrintWriter);
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
                Object res = engine.eval(buffer.toString());
                commandPrintWriter.flush();
                String ret = commandOutput.toString() + (res == null ? "" : res.toString() + "\n");
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
