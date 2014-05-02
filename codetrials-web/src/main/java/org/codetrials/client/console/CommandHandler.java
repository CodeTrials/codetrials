package org.codetrials.client.console;

/**
 * @author Nikita Zyulyaev
 */
public interface CommandHandler {
    void handle(String line, ConsoleReporter reporter);
}
