package org.codetrials.client.trialform;

import com.google.inject.Inject;
import org.codetrials.client.core.logging.Log;
import org.codetrials.client.core.mvp.BasePresenter;

/**
 * @author Nikita Zyulyaev
 */
class TrialFormPresenterImpl extends BasePresenter<TrialFormView> implements TrialFormPresenter {
    @Inject
    TrialFormPresenterImpl(TrialFormView view) {
        super(view);
    }

    @Override
    public void onBundleUploaded(String results) {
        Log.info(results);
    }
}
