package org.codetrials.bundle;

import java.util.List;

/**
 * Handle tasks as simple list.
 *
 * @author Polyarnyi Nikolay
 */
public abstract class SimpleBundleContainer extends BundleContainer {

    private final List<Task> tasks;
    private int currentStep = 0;

    protected SimpleBundleContainer(List<Task> tasks) {
        this.tasks = tasks;
    }

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
