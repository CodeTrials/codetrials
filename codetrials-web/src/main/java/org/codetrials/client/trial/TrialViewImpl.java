package org.codetrials.client.trial;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.HeadingElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.codetrials.client.console.ConsoleBuilder;
import org.codetrials.client.console.JqueryConsoleBuilder;
import org.codetrials.client.core.mvp.BaseView;

/**
 * @author Nikita Zyulyaev
 */
class TrialViewImpl extends BaseView<TrialPresenter> implements TrialView {
    interface TrialViewUiBinder extends UiBinder<HTMLPanel, TrialViewImpl> {}
    private static final TrialViewUiBinder UI_BINDER = GWT.create(TrialViewUiBinder.class);
    @UiField
    DivElement progress;
    @UiField
    HeadingElement title;
    @UiField
    Element description;
    @UiField
    DivElement consoleContainer;

    TrialViewImpl() {
        initWidget(UI_BINDER.createAndBindUi(this));
    }

    @Override
    public void setProgress(int current, int tasks) {
        progress.setAttribute("style", "min-width: 40px; width: " + ((float) current / tasks * 100) + "%;");
        progress.setInnerHTML(current + "/" + tasks);
    }

    @Override
    public void setTaskLegend(String title, String description) {
        this.title.setInnerHTML(title);
        this.description.setInnerHTML(description);
    }

    @Override
    public ConsoleBuilder initConsole() {
        consoleContainer.removeAllChildren();
        Element console = DOM.createDiv();
        console.setClassName("console");
        consoleContainer.appendChild(console);
        return new JqueryConsoleBuilder(console);
    }
}
