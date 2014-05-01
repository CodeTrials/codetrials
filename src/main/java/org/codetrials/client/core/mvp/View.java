package org.codetrials.client.core.mvp;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * @author Nikita Zyulyaev
 */
public interface View<P extends Presenter<? extends View<? super P>>> extends IsWidget {
    void setPresenter(P presenter);
    P getPresenter();
}
