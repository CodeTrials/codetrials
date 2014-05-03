package org.codetrials.client.trialsmanager;

import com.google.gwt.core.client.JavaScriptObject;
import org.codetrials.shared.entities.Trial;

/**
 * @author Nikita Zyulyaev
 */
public class JsTrial extends JavaScriptObject {
    protected JsTrial() {
    }

    public final native int getId() /*-{
        return this.id;
    }-*/;

    public final native String getTitle() /*-{
        return this.title;
    }-*/;

    public final native String getDescription() /*-{
        return this.description;
    }-*/;

    public final native int getTaskCount() /*-{
        return this.taskCount;
    }-*/;

    public final Trial toTrial() {
        return new Trial(getId(), getTitle(), getDescription(), getTaskCount());
    }
}
