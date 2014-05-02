package org.codetrials.client.trialsgrid;

import com.google.inject.ImplementedBy;
import org.codetrials.client.core.mvp.Presenter;
import org.codetrials.shared.entities.Trial;

/**
 * @author Nikita Zyulyaev
 */
@ImplementedBy(TrialsGridPresenterImpl.class)
public interface TrialsGridPresenter extends Presenter<TrialsGridView> {
    void onTrialSelected(Trial trial);
}
