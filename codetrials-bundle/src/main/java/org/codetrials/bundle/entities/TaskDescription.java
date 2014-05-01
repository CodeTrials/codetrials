package org.codetrials.bundle.entities;

/**
 * @author Polyarnyi Nikolay
 */
public class TaskDescription {

    private String title;
    private String description;

    public TaskDescription(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
