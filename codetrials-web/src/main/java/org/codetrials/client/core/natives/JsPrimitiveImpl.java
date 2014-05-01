package org.codetrials.client.core.natives;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Nikita Zyulyaev
 */
class JsPrimitiveImpl extends JavaScriptObject implements JsPrimitive {
    protected JsPrimitiveImpl() {
    }

    @Override
    public final native boolean isNull() /*-{
        return this == null;
    }-*/;

    @Override
    public final native boolean isUndefined() /*-{
        return this == undefined;
    }-*/;

    @Override
    public final native boolean isExactlyNull() /*-{
        return this === null;
    }-*/;

    @Override
    public final native boolean isExactlyUndefined() /*-{
        return this === undefined;
    }-*/;

    @Override
    public final native String asString() /*-{
        return this + "";
    }-*/;
}
