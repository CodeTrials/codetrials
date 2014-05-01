package org.codetrials.client.core.natives;

import com.google.gwt.core.client.SingleJsoImpl;

/**
 * @author Nikita Zyulyaev
 */
@SingleJsoImpl(JsBooleanImpl.class)
public interface JsBoolean extends JsPrimitive {
    boolean get();
}
