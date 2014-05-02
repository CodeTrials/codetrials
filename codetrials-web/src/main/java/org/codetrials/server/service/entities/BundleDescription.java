package org.codetrials.server.service.entities;

/**
 * @author Polyarnyi Nikolay
 */
public class BundleDescription {

    private final int id;
    private final String title;
    private final String description;

    public BundleDescription(String description, String title, int id) {
        this.description = description;
        this.title = title;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
