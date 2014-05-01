package org.codetrials.client.core.events;

/**
 * @author Nikita Zyulyaev
 */
public interface ClassifiedEventSubscription<T> extends EventSubscription<T> {
    String getClassifier();
}
