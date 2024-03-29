package org.codetrials.client.console;

/**
 * @author Nikita Zyulyaev
 */
public interface Console {
    void setPromptText(String text);
    void reset();
    void setPromptContinued(boolean continued);
    boolean isPromptContinued();
}
