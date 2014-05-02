package org.codetrials.bundle.engines;

import org.codetrials.bundle.entities.ExecutionResult;

public interface BundleEngine {

    public ExecutionResult exec(String command);

}
