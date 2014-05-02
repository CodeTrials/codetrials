package org.codetrials.client.console;

/**
 * @author Nikita Zyulyaev
 */
public class JqueryConsole implements Console {
    private final JqueryConsoleController controller;

    public JqueryConsole(JqueryConsoleController controller) {
        this.controller = controller;
    }

    @Override
    public void setPromptText(String text) {
        controller.promptText(text);
    }

    @Override
    public void reset() {
        controller.reset();
    }

    @Override
    public void setPromptContinued(boolean continued) {
        controller.setPromptContinued(continued);
    }

    @Override
    public boolean isPromptContinued() {
        return controller.isPromptContinued();
    }
}
