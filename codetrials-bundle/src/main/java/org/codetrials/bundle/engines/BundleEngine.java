package org.codetrials.bundle.engines;

import org.codetrials.bundle.entities.ExecutionResult;

public abstract class BundleEngine {

    public abstract ExecutionResult exec(String command);

}
