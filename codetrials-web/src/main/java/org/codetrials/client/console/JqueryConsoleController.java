package org.codetrials.client.console;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Nikita Zyulyaev
 */
public class JqueryConsoleController extends JavaScriptObject {
    protected JqueryConsoleController() {
    }

    public final native void reset() /*-{
        this.reset();
    }-*/;

    public final native void promptText(String text) /*-{
        this.promptText(text);
    }-*/;

    public final native void setPromptContinued(boolean continued) /*-{
        this.continuedPrompt = continued;
    }-*/;

    public final native boolean isPromptContinued() /*-{
        return this.continuedPrompt;
    }-*/;
}
