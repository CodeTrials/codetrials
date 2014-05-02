package org.codetrials.client.trialform;

import com.google.inject.ImplementedBy;
import org.codetrials.client.core.mvp.Presenter;

/**
 * @author Nikita Zyulyaev
 */
@ImplementedBy(TrialFormPresenterImpl.class)
public interface TrialFormPresenter extends Presenter<TrialFormView> {
    void onBundleUploaded(String results);
}
