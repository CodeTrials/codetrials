package org.codetrials.client.trialsgrid;

import com.google.inject.Inject;
import org.codetrials.client.ContentManager;
import org.codetrials.client.core.events.EventBus;
import org.codetrials.client.core.events.Handler;
import org.codetrials.client.core.mvp.BasePresenter;
import org.codetrials.client.trialsmanager.TrialsManager;
import org.codetrials.shared.entities.Trial;

/**
 * @author Nikita Zyulyaev
 */
class TrialsGridPresenterImpl extends BasePresenter<TrialsGridView> implements TrialsGridPresenter {
    private final EventBus bus;
    @Inject
    public TrialsGridPresenterImpl(final TrialsGridView view, final TrialsManager trialsManager, EventBus bus) {
        super(view);
        this.bus = bus;

        view.setTrials(trialsManager.getTrials());

        bus.subscribe(TrialsManager.NEW_TRIAL, new Handler<Trial>() {
            @Override
            public void handle(Trial event) {
                view.setTrials(trialsManager.getTrials());
            }
        });
    }

    @Override
    public void onTrialSelected(Trial trial) {
        bus.fire(ContentManager.SHOW_TRIAL, trial);
    }
}
