package org.codetrials.client.core.util;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NativeEvent;
import org.codetrials.client.core.events.Handler;

/**
 * @author Nikita Zyulyaev
 */
public final class DOMUtils {
    private DOMUtils() {}

    public static void addOnClickListener(Element element, Handler<NativeEvent> handler) {
        addEventListener(element, "click", handler);
    }

    private static void addEventListener(Element element, String type, Handler<NativeEvent> handler) {
        addEventListenerNative(element, type, bindHandler(handler));
    }

    private static native void addEventListenerNative(Element element, String type, JavaScriptObject listener) /*-{
        element.addEventListener(type, listener, false);
    }-*/;

    private static native JavaScriptObject bindHandler(Handler<?> handler) /*-{
       return handler.@org.codetrials.client.core.events.Handler::handle(Ljava/lang/Object;).bind(handler);
    }-*/;
}
