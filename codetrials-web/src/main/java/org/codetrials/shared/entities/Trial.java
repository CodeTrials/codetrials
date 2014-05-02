package org.codetrials.shared.entities;

/**
 * @author Nikita Zyulyaev
 */
public class Trial {
    private final String title;
    private final String description;

    public Trial(String title, String description) {
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
