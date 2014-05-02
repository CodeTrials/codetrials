package org.codetrials.client.console;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;
import org.codetrials.client.core.natives.JsMap;
import org.codetrials.client.core.natives.NativeUtils;

/**
 * @author Nikita Zyulyaev
 */
public class JqueryConsoleBuilder implements ConsoleBuilder {
    private final Element element;
    private final JsMap<Object> options = NativeUtils.map();

    public JqueryConsoleBuilder(Element element) {
        this.element = element;
    }

    private static native JavaScriptObject makeValidateFunction(CommandValidator validator) /*-{
        return function(line) {
            return validator.@org.codetrials.client.console.CommandValidator::validate(Ljava/lang/String;)(line);
        };
    }-*/;

    @Override
    public ConsoleBuilder setCommandValidator(CommandValidator validator) {
        options.put("commandValidate", makeValidateFunction(validator));
        return this;
    }

    @Override
    public ConsoleBuilder setPromptLabel(String promptLabel) {
        options.put("promptLabel", promptLabel);
        return this;
    }

    @Override
    public ConsoleBuilder setWelcomeMessage(String welcomeMessage) {
        options.put("welcomeMessage", welcomeMessage);
        return this;
    }

    private static native JavaScriptObject makeCommandHandleFunction(CommandHandler handler) /*-{
        return function(line, report) {
            handler.@org.codetrials.client.console.CommandHandler::handle(Ljava/lang/String;Lorg/codetrials/client/console/ConsoleReporter;)(line, report);
        };
    }-*/;

    @Override
    public ConsoleBuilder setCommandHandler(CommandHandler handler) {
        options.put("commandHandle", makeCommandHandleFunction(handler));
        return this;
    }

    @Override
    public ConsoleBuilder setAutofocus(boolean autofocus) {
        options.put("autofocus", autofocus);
        return this;
    }

    @Override
    public Console build() {
        return new JqueryConsole(buildNative(element, options));
    }

    private static native JqueryConsoleController buildNative(Element element, JsMap<Object> options) /*-{
        return $wnd.jQuery(element).console(options);
    }-*/;
}
