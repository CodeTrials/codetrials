package org.codetrials.client.core.natives;

import com.google.gwt.core.client.SingleJsoImpl;

/**
 * @author Nikita Zyulyaev
 */
@SingleJsoImpl(JsPrimitiveImpl.class)
public interface JsPrimitive {
    boolean isNull();
    boolean isUndefined();
    boolean isExactlyNull();
    boolean isExactlyUndefined();

    String asString();
}
