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

    @Inject
    public void initContainer(
            EventBus bus,
            final TrialsGridPresenter trialsGridPresenter,
            final TrialPresenter trialPresenter,
            final TrialFormPresenter formPresenter) {
        final RootPanel root = RootPanel.get(LayoutConstants.CONTAINER_ID);

        final Widget trialsGridView = trialsGridPresenter.getView().asWidget();
        final Widget trialView = trialPresenter.getView().asWidget();
        final Widget formView = formPresenter.getView().asWidget();

        root.add(trialsGridView);
        root.add(trialView);
        root.add(formView);

        trialView.setVisible(false);
        formView.setVisible(false);

        bus.subscribe(SHOW_TRIAL, new Handler<Trial>() {
            @Override
            public void handle(Trial event) {
                trialsGridView.setVisible(false);
                formView.setVisible(false);
                trialView.setVisible(true);
            }
        });
        bus.subscribe(SHOW_INDEX, new Handler<Void>() {
            @Override
            public void handle(Void event) {
                trialView.setVisible(false);
                formView.setVisible(false);
                trialsGridView.setVisible(true);
            }
        });
        bus.subscribe(SHOW_FORM, new Handler<Void>() {
            @Override
            public void handle(Void event) {
                trialView.setVisible(false);
                trialsGridView.setVisible(false);
                formView.setVisible(true);
            }
        });
    }
}
