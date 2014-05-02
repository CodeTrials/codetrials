package org.codetrials.server.service.dao;

/**
 * @author by qwwdfsad
 */
public class BundleDescription {
    private final int id;
    private final String title;
    private final String description;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BundleDescription(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }
}
