package org.codetrials.client.navbar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HTMLPanel;
import org.codetrials.client.core.mvp.BaseView;

/**
 * @author Nikita Zyulyaev
 */
class NavBarViewImpl extends BaseView<NavBarPresenter> implements NavBarView {
    interface NavBarViewUiBinder extends UiBinder<HTMLPanel, NavBarViewImpl> {}
    private static final NavBarViewUiBinder UI_BINDER = GWT.create(NavBarViewUiBinder.class);

    @UiField
    Anchor logo;
    @UiField
    Button addTrial;

    public NavBarViewImpl() {
        initWidget(UI_BINDER.createAndBindUi(this));
    }

    @UiHandler("logo")
    public void onLogoClicked(ClickEvent event) {
        presenter.onLogoClicked();
    }

    @UiHandler("addTrial")
    public void onAddTrialClicked(ClickEvent event) {
        presenter.onCreateTrial();
    }
}
