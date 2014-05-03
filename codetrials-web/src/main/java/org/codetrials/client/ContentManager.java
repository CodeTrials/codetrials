package org.codetrials.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.codetrials.client.core.events.EventBus;
import org.codetrials.client.core.events.EventType;
import org.codetrials.client.core.events.Handler;
import org.codetrials.client.trial.TrialPresenter;
import org.codetrials.client.trialform.TrialFormPresenter;
import org.codetrials.client.trialsgrid.TrialsGridPresenter;
import org.codetrials.client.trialsmanager.TrialsManager;
import org.codetrials.shared.LayoutConstants;
import org.codetrials.shared.entities.Trial;

/**
 * @author Nikita Zyulyaev
 */
@Singleton
public class ContentManager {
    public static final EventType<Trial> SHOW_TRIAL = new EventType<>("SHOW_TRIAL");
    public static final EventType<Void> SHOW_INDEX = new EventType<>("SHOW_INDEX");
    public static final EventType<Void> SHOW_FORM = new EventType<>("SHOW_FORM");
    private Widget trialsGridView;
    private Widget trialView;
    private Widget formView;

    @Inject
    public void initContainer(
            EventBus bus,
            final TrialsGridPresenter trialsGridPresenter,
            final TrialPresenter trialPresenter,
            final TrialFormPresenter formPresenter) {
        final RootPanel root = RootPanel.get(LayoutConstants.CONTAINER_ID);

        trialsGridView = trialsGridPresenter.getView().asWidget();
        trialView = trialPresenter.getView().asWidget();
        formView = formPresenter.getView().asWidget();

        root.add(trialsGridView);
        root.add(trialView);
        root.add(formView);

        bus.subscribe(SHOW_TRIAL, new Handler<Trial>() {
            @Override
            public void handle(Trial event) {
                showTrial();
            }
        });
        bus.subscribe(SHOW_INDEX, new Handler<Void>() {
            @Override
            public void handle(Void event) {
                showIndex();
            }
        });
        bus.subscribe(SHOW_FORM, new Handler<Void>() {
            @Override
            public void handle(Void event) {
                showForm();
            }
        });
        bus.subscribe(TrialsManager.NEW_TRIAL, new Handler<Trial>() {
            @Override
            public void handle(Trial event) {
                showIndex();
            }
        });

        showIndex();
    }

    private void showForm() {
        trialView.setVisible(false);
        trialsGridView.setVisible(false);
        formView.setVisible(true);
    }

    private void showIndex() {
        trialView.setVisible(false);
        formView.setVisible(false);
        trialsGridView.setVisible(true);
    }

    private void showTrial() {
        trialsGridView.setVisible(false);
        formView.setVisible(false);
        trialView.setVisible(true);
    }
}
