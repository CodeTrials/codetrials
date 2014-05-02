package org.codetrials.client.trial;

import com.google.inject.ImplementedBy;
import org.codetrials.client.console.ConsoleBuilder;
import org.codetrials.client.core.mvp.View;

/**
 * @author Nikita Zyulyaev
 */
@ImplementedBy(TrialViewImpl.class)
public interface TrialView extends View<TrialPresenter> {
    void setProgress(int current, int tasks);
    void setTaskLegend(String title, String description);
    ConsoleBuilder initConsole();
}
