package org.codetrials.bundle.helpers;

import org.codetrials.bundle.BundleContainer;
import org.codetrials.bundle.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Handle tasks as simple list.
 *
 * @author Polyarnyi Nikolay
 */
public abstract class SimpleBundleContainer extends BundleContainer {

    private final List<Task> tasks = createTasks();
    private int currentStep = 0;

    abstract protected List<Task> createTasks();

    @Override
    public int getCurrentStepNumber() {
        return currentStep;
    }

    @Override
    public int getTotalStepsCount() {
        return tasks.size();
    }

    @Override
    protected Task getCurrentTask() {
        return tasks.get(currentStep);
    }

    @Override
    protected void moveToNextTask() {
        currentStep++;
    }
}
