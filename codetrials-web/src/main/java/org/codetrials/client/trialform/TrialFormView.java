package org.codetrials.client.trialform;

import com.google.inject.ImplementedBy;
import org.codetrials.client.core.mvp.View;

/**
 * @author Nikita Zyulyaev
 */
@ImplementedBy(TrialFormViewImpl.class)
public interface TrialFormView extends View<TrialFormPresenter> {
}
