package org.codetrials.client.core.natives;

/**
 * @author Nikita Zyulyaev
 */
class JsDoubleImpl extends JsPrimitiveImpl implements JsDouble {
    protected JsDoubleImpl() {
    }

    @Override
    public final native double get() /*-{
        return this;
    }-*/;
}
