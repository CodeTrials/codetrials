package org.codetrials.client.navbar;

import com.google.inject.ImplementedBy;
import org.codetrials.client.core.mvp.Presenter;

/**
 * @author Nikita Zyulyaev
 */
@ImplementedBy(NavBarPresenterImpl.class)
public interface NavBarPresenter extends Presenter<NavBarView> {
    void onLogoClicked();
    void onCreateTrial();
}
