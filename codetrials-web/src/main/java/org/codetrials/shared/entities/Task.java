package org.codetrials.shared.entities;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Polyarnyi Nikolay
 */
public class Task implements IsSerializable {

    private String title;
    private String description;
    private int id;

    private Task() {
    }

    public Task(String description, String title, int id) {
        this.description = description;
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getID() {
        return id;
    }
}
