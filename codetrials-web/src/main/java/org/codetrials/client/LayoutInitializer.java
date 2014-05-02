package org.codetrials.client;

import com.google.gwt.user.client.ui.RootPanel;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.codetrials.client.navbar.NavBarPresenter;

/**
 * @author Nikita Zyulyaev
 */
@Singleton
public class LayoutInitializer {
    @Inject
    public void initNavBar(NavBarPresenter navBar) {
        RootPanel.get().insert(navBar.getView(), 0);
    }

    @Inject
    public void initTrialsGrid(ContentManager contentManager) {}
}
