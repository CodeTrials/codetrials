package org.codetrials.client.core.mvp;

/**
 * @author Nikita Zyulyaev
 */
public class BasePresenter<V extends View<? extends Presenter<? super V>>> implements Presenter<V> {
    protected final V view;

    public BasePresenter(V view) {
        this.view = view;
        ((View)view).setPresenter(this);
    }

    @Override
    public V getView() {
        return view;
    }
}
