package org.codetrials.client.navbar;

import com.google.inject.Inject;
import org.codetrials.client.ContentManager;
import org.codetrials.client.core.events.EventBus;
import org.codetrials.client.core.mvp.BasePresenter;

/**
 * @author Nikita Zyulyaev
 */
class NavBarPresenterImpl extends BasePresenter<NavBarView> implements NavBarPresenter {
    private final EventBus bus;

    @Inject
    public NavBarPresenterImpl(NavBarView view, EventBus bus) {
        super(view);
        this.bus = bus;
    }

    @Override
    public void onLogoClicked() {
        bus.fire(ContentManager.SHOW_INDEX, null);
    }

    @Override
    public void onCreateTrial() {
        bus.fire(ContentManager.SHOW_FORM, null);
    }
}
