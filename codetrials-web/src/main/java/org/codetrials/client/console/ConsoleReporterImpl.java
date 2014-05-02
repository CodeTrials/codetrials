package org.codetrials.client.console;

import com.google.gwt.core.client.JavaScriptObject;
import org.codetrials.client.core.natives.JsList;

/**
 * @author Nikita Zyulyaev
 */
public class ConsoleReporterImpl extends JavaScriptObject implements ConsoleReporter {
    protected ConsoleReporterImpl() {
    }

    @Override
    public final native void report(JsList<ConsoleMessage> messages) /*-{
        return this(messages);
    }-*/;
}
