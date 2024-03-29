package org.codetrials.bundle.helpers;

import org.codetrials.bundle.BundleContainer;
import org.codetrials.bundle.Task;
import org.codetrials.bundle.engines.BundleEngine;

import java.util.List;

/**
 * Handle tasks as simple list.
 *
 * @author Polyarnyi Nikolay
 */
public abstract class SimpleBundleContainer extends BundleContainer {

    private List<Task> tasks;
    private int currentStep = 0;

    protected SimpleBundleContainer(BundleEngine engine) {
        super(engine);
    }

    @Override
    public void initTasks() {
        tasks = createTasks();
    }

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
