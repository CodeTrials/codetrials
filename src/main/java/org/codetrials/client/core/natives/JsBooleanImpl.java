package org.codetrials.client.core.natives;

/**
 * @author Nikita Zyulyaev
 */
class JsBooleanImpl extends JsPrimitiveImpl implements JsBoolean {
    protected JsBooleanImpl() {
    }

    @Override
    public final native boolean get() /*-{
        return this;
    }-*/;
}
