package org.codetrials.shared.entities;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Polyarnyi Nikolay
 */
public class Task implements IsSerializable {

    private String title;
    private String description;

    private Task() {
    }

    public Task(String description, String title) {
        this.description = description;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
