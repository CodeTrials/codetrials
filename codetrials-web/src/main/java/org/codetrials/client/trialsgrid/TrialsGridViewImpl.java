package org.codetrials.client.trialsgrid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.codetrials.client.core.events.Handler;
import org.codetrials.client.core.mvp.BaseView;
import org.codetrials.shared.entities.Trial;

import java.util.List;

/**
 * @author Nikita Zyulyaev
 */
class TrialsGridViewImpl extends BaseView<TrialsGridPresenter> implements TrialsGridView {
    interface TrialsGridViewUiBinder extends UiBinder<HTMLPanel, TrialsGridViewImpl> {}
    private static final TrialsGridViewUiBinder UI_BINDER = GWT.create(TrialsGridViewUiBinder.class);
    @UiField
    FlowPanel grid;

    private final Handler<Trial> trialSelectedHandler = new Handler<Trial>() {
        @Override
        public void handle(Trial event) {
            presenter.onTrialSelected(event);
        }
    };

    public TrialsGridViewImpl() {
        initWidget(UI_BINDER.createAndBindUi(this));
    }

    @Override
    public void setTrials(List<? extends Trial> trials) {
        grid.clear();
        for (Trial trial : trials) {
            grid.add(new TrialCell(trial, trialSelectedHandler));
        }
    }
}
