package org.codetrials.client.core.events;

/**
 * @author Nikita Zyulyaev
 */
public class EventType<T> {
    private static int counter = 0;

    private final String name;
    int id = counter++;

    public EventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
