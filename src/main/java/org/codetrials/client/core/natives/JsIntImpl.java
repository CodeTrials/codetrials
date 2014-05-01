package org.codetrials.client.core.natives;

/**
 * @author Nikita Zyulyaev
 */
class JsIntImpl extends JsPrimitiveImpl implements JsInt {
    protected JsIntImpl() {
    }

    @Override
    public final native int get() /*-{
        return this;
    }-*/;
}
