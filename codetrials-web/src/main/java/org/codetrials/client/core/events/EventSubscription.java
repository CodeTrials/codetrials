package org.codetrials.client.core.events;

/**
 * @author Nikita Zyulyaev
 */
public interface EventSubscription<T> {
    EventType<T> getEventType();
    Handler<? super T> getHandler();

    boolean unsubscribe();
}
