package org.codetrials.client.trialsgrid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.AnchorElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Widget;
import org.codetrials.client.core.events.Handler;
import org.codetrials.client.core.util.DOMUtils;
import org.codetrials.shared.entities.Trial;

/**
 * @author Nikita Zyulyaev
 */
class TrialCell extends Widget {
    interface TrialCellUiBinder extends UiBinder<Element, TrialCell> {}
    private static final TrialCellUiBinder UI_BINDER = GWT.create(TrialCellUiBinder.class);
    @UiField(provided = true)
    String title;
    @UiField(provided = true)
    String description;
    @UiField
    AnchorElement tryButton;

    public TrialCell(final Trial trial, final Handler<? super Trial> onTrialSelected) {
        this.title = trial.getTitle();
        this.description = trial.getDescription();
        setElement(UI_BINDER.createAndBindUi(this));

        DOMUtils.addOnClickListener(tryButton, new Handler<NativeEvent>() {
            @Override
            public void handle(NativeEvent event) {
                onTrialSelected.handle(trial);
            }
        });
    }
}
