package org.codetrials.client.console;

/**
 * @author Nikita Zyulyaev
 */
public interface ConsoleBuilder {
    ConsoleBuilder setCommandValidator(CommandValidator validator);
    ConsoleBuilder setPromptLabel(String promptLabel);
    ConsoleBuilder setContinuedPromptLabel(String continuedPromptLabel);
    ConsoleBuilder setWelcomeMessage(String welcomeMessage);
    ConsoleBuilder setCommandHandler(CommandHandler handler);
    ConsoleBuilder setAutofocus(boolean autofocus);

    Console build();
}
