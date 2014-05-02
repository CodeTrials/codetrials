package org.codetrials.client.trial;

import com.google.inject.ImplementedBy;
import org.codetrials.client.core.mvp.Presenter;

/**
 * @author Nikita Zyulyaev
 */
@ImplementedBy(TrialPresenterImpl.class)
public interface TrialPresenter extends Presenter<TrialView> {
}
