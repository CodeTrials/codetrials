package org.codetrials.shared.entities;

/**
 * @author by qwwdfsad
 */
public class BundleDescription {
    private final int id;
    private final String title;
    private final String path;
    private final String description;

    public String getDescription() {
        return description;
    }
    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public BundleDescription(int id, String title, String path, String descr) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.description = descr;
    }
}
