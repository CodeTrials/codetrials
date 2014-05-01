package org.codetrials.client.core.logging;

import com.google.gwt.core.client.JavaScriptObject;
import org.codetrials.client.core.natives.JsArray;

/**
 * @author Nikita Zyulyaev
 */
public class Logger extends JavaScriptObject {
    protected Logger() {
    }

    public final native void log(Object message) /*-{
        console.log(message);
    }-*/;

    public final native void info(Object message) /*-{
        console.info(message);
    }-*/;

    public final native void warn(Object message) /*-{
        console.warn(message);
    }-*/;

    public final native void error(Object message) /*-{
        console.error(message);
    }-*/;


    public final native void log(JsArray<?> messages) /*-{
        console.log.apply(console, messages);
    }-*/;

    public final native void info(JsArray<?> messages) /*-{
        console.info.apply(console, messages);
    }-*/;

    public final native void warn(JsArray<?> messages) /*-{
        console.warn.apply(console, messages);
    }-*/;

    public final native void error(JsArray<?> messages) /*-{
        console.error.apply(console, messages);
    }-*/;
}
