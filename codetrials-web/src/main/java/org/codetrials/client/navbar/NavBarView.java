package org.codetrials.client.navbar;

import com.google.inject.ImplementedBy;
import org.codetrials.client.core.mvp.View;

/**
 * @author Nikita Zyulyaev
 */
@ImplementedBy(NavBarViewImpl.class)
public interface NavBarView extends View<NavBarPresenter> {
}
