package org.codetrials.client.trialsgrid;

import com.google.inject.ImplementedBy;
import org.codetrials.client.core.mvp.View;
import org.codetrials.shared.entities.Trial;

import java.util.List;

/**
 * @author Nikita Zyulyaev
 */
@ImplementedBy(TrialsGridViewImpl.class)
public interface TrialsGridView extends View<TrialsGridPresenter> {
    void setTrials(List<? extends Trial> trials);
}
