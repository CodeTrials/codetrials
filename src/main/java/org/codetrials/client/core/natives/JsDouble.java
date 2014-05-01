package org.codetrials.client.core.natives;

import com.google.gwt.core.client.SingleJsoImpl;

/**
 * @author Nikita Zyulyaev
 */
@SingleJsoImpl(JsDoubleImpl.class)
public interface JsDouble extends JsPrimitive {
    double get();
}
