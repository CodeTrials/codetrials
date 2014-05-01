package org.codetrials.client.core.events;

/**
 * @author Nikita Zyulyaev
 */
public interface Handler<T> {
    void handle(T event);
}
