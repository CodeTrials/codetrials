package org.codetrials.bundle.entities;

/**
 * @author Polyarnyi Nikolay
 */
public class TaskDescription {

    private final String title;
    private final String description;
    private final int id;

    public TaskDescription(String title, String description) {
        this(title, description, -1);
    }

    public TaskDescription(String title, String description, int id) {
        this.title = title;
        this.description = description;
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
