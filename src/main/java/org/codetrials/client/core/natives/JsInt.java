package org.codetrials.client.core.natives;

import com.google.gwt.core.client.SingleJsoImpl;

/**
 * @author Nikita Zyulyaev
 */
@SingleJsoImpl(JsIntImpl.class)
public interface JsInt extends JsPrimitive {
    int get();
}
