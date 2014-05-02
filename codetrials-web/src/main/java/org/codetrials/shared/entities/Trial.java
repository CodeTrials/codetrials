package org.codetrials.shared.entities;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Nikita Zyulyaev
 */
public class Trial implements IsSerializable {

    private int id;
    private String title;
    private String description;
    private int taskCount;

    private Trial() {
    }

    public Trial(int id, String title, String description, int taskCount) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.taskCount = taskCount;
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

    public int getTaskCount() {
        return taskCount;
    }
}
