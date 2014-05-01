package org.codetrials.client.core.events;

/**
 * @author Nikita Zyulyaev
 */
public class ClassifiedEventType<T> {
    private final EventType<T> type;
    private final String classifier;

    public ClassifiedEventType(EventType<T> type, String classifier) {
        this.type = type;
        this.classifier = classifier;
    }

    public EventType<T> getType() {
        return type;
    }

    public String getClassifier() {
        return classifier;
    }
}
