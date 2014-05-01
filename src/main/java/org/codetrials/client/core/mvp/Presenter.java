package org.codetrials.client.core.mvp;

/**
 * @author Nikita Zyulyaev
 */
public interface Presenter<V extends View<? extends Presenter<? super V>>> {
    V getView();
}
