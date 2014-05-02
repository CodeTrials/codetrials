package org.codetrials.client.core.natives;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Nikita Zyulyaev
 */
class JsMapImpl<V> extends JavaScriptObject implements JsMap<V> {
    protected JsMapImpl() {
    }

    @Override
    public final native V get(String key) /*-{
        return this[key];
    }-*/;

    @Override
    public final native void put(String key, V value) /*-{
        this[key] = value;
    }-*/;

    @Override
    public final native void remove(String key) /*-{
        delete this[key];
    }-*/;

    @Override
    public final native boolean containsKey(String key) /*-{
        return key in this;
    }-*/;

    @Override
    public final native JsList<String> keys() /*-{
        return Object.keys(this);
    }-*/;
}
