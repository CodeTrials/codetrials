package org.codetrials.client.trial;

import com.google.inject.Inject;
import org.codetrials.client.ContentManager;
import org.codetrials.client.console.CommandHandler;
import org.codetrials.client.console.ConsoleMessage;
import org.codetrials.client.console.ConsoleReporter;
import org.codetrials.client.core.events.EventBus;
import org.codetrials.client.core.events.Handler;
import org.codetrials.client.core.mvp.BasePresenter;
import org.codetrials.client.core.natives.NativeUtils;
import org.codetrials.shared.entities.Trial;

/**
 * @author Nikita Zyulyaev
 */
class TrialPresenterImpl extends BasePresenter<TrialView> implements TrialPresenter {
    @Inject
    TrialPresenterImpl(final TrialView view, EventBus bus) {
        super(view);

        bus.subscribe(ContentManager.SHOW_TRIAL, new Handler<Trial>() {
            @Override
            public void handle(Trial event) {
                view.setTaskLegend(event.getTitle(), event.getDescription());
                view.initConsole()
                        .setAutofocus(true)
                        .setCommandHandler(new CommandHandler() {
                            @Override
                            public void handle(String line, ConsoleReporter reporter) {
                                reporter.report(NativeUtils.listOf(ConsoleMessage.of("OK", "jquery-console-message-value")));
                            }
                        })
                        .setPromptLabel(">>> ")
                        .setWelcomeMessage("Welcome to " + event.getTitle())
                        .build();
            }
        });
    }
}
