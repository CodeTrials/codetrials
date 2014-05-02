package org.codetrials.client.console;

import com.google.gwt.core.client.SingleJsoImpl;
import org.codetrials.client.core.natives.JsList;

/**
 * @author Nikita Zyulyaev
 */
@SingleJsoImpl(ConsoleReporterImpl.class)
public interface ConsoleReporter {
    void report(JsList<ConsoleMessage> messages);
}
