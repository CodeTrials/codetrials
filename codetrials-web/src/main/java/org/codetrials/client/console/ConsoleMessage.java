package org.codetrials.client.console;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Nikita Zyulyaev
 */
public class ConsoleMessage extends JavaScriptObject {
    protected ConsoleMessage() {
    }

    public final native void setMessage(String message) /*-{
        this.msg = message;
    }-*/;

    public final native void setClassName(String className) /*-{
        this.className = className;
    }-*/;

    public static native ConsoleMessage of(String message, String className) /*-{
        return { msg: message, className: className };
    }-*/;
}
