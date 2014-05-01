package org.codetrials.client.core.mvp;

import com.google.gwt.user.client.ui.Composite;

/**
 * @author Nikita Zyulyaev
 */
public class BaseView<P extends Presenter<? extends View<? super P>>> extends Composite implements View<P> {
    protected P presenter;

    @Override
    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override
    public P getPresenter() {
        return presenter;
    }
}
