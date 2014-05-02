package org.codetrials.client.trialsmanager;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Nikita Zyulyaev
 */
class JsTrial extends JavaScriptObject {
    protected JsTrial() {
    }

    public final native String getTitle() /*-{
        return this.title;
    }-*/;

    public final native String getDescription() /*-{
        return this.description;
    }-*/;
}