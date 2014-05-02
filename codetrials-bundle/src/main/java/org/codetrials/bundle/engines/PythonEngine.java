package org.codetrials.bundle.engines;

import com.sun.script.jython.JythonScriptEngineFactory;
import org.codetrials.bundle.entities.ExecutionResult;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;

/**
 * Created by vlpolyansky.
 */
public class PythonEngine implements BundleEngine {

    private ScriptEngine engine;

    public PythonEngine() {
        ScriptEngineFactory factory = new JythonScriptEngineFactory();
        engine = factory.getScriptEngine();
    }

    @Override
    public ExecutionResult exec(String command) {
        return null;
    }
}
