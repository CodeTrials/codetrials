package org.codetrials.shared.entities;

/**
 * @author by qwwdfsad
 */
public class BundleDescription {
    private final int id;
    private final String title;
    private final String path;
    private final String description;
    private final int taskCount;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getPath() {
        return path;
    }

    public String getTitle() {
        return title;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public BundleDescription(int id, String title, String path, String descr, int taskCount) {
        this.id = id;
        this.title = title;
        this.path = path;
        this.description = descr;
        this.taskCount = taskCount;
    }
}
