package org.codetrials.bundle.engines;

import com.sun.script.jython.JythonScriptEngineFactory;
import org.codetrials.bundle.entities.ExecutionResult;
import org.codetrials.bundle.exceptions.CommandException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by vlpolyansky.
 */
public class PythonEngine implements BundleEngine {

    private ScriptEngine engine;
    private ByteArrayOutputStream buffer;
    private PrintStream bufferPrintStream;
    private int balance;

    public PythonEngine() {
        ScriptEngineFactory factory = new JythonScriptEngineFactory();
        engine = factory.getScriptEngine();

        buffer = new ByteArrayOutputStream();
        bufferPrintStream = new PrintStream(buffer);
        balance = 0;
    }

    @Override
    public ExecutionResult exec(String command) {
        updateBalance(command);
        bufferPrintStream.println(command);
        bufferPrintStream.flush();
        if (balance == 0) {
            try {
                Object obj = engine.eval(buffer.toString());
                return new ExecutionResult(obj == null ? null : obj.toString(), null);
            } catch (ScriptException e) {
                return new ExecutionResult(null, new CommandException(null, e));
            } finally {
                reset();
            }
        } else {
            return null;
        }
    }

    private boolean updateBalance(String command) {
        if (command.trim().endsWith(":")) {
            balance++;
        } else if (command.trim().length() == 0) {
            balance = 0;
        }
        return true;
    }

    private void reset() {
        buffer.reset();
        balance = 0;
    }

    public static void main(String[] args) {
        PythonEngine engine = new PythonEngine();
        ExecutionResult res = engine.exec("(1 + 2)");
        System.out.println(res.getExecutionOutput());
    }

}
