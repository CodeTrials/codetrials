package org.codetrials.client.core.events;

import com.google.inject.ImplementedBy;
import com.google.inject.Singleton;

/**
 * @author Nikita Zyulyaev
 */
@Singleton
@ImplementedBy(EventBusImpl.class)
public interface EventBus {
    <T> EventSubscription<T> subscribe(EventType<T> type, Handler<? super T> handler);
    <T> ClassifiedEventSubscription<T> subscribe(ClassifiedEventType<T> type, Handler<? super T> handler);
    <T> ClassifiedEventSubscription<T> subscribe(EventType<T> type, String classifier, Handler<? super T> handler);

    <T> void fire(EventType<T> type, T value);
    <T> void fire(ClassifiedEventType<T> type, T value);
    <T> void fire(EventType<T> type, String classifier, T value);
}
