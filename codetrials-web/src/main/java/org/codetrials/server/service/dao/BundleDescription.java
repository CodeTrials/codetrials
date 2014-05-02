package org.codetrials.server.service.dao;

/**
 * @author by qwwdfsad
 */
public class BundleDescription {
    private final int id;
    private final String title;
    private final String path;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    BundleDescription(int id, String title, String path) {
        this.id = id;
        this.title = title;
        this.path = path;
    }
}
