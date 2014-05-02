package org.codetrials.client.trial;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import org.codetrials.client.ContentManager;
import org.codetrials.client.console.CommandHandler;
import org.codetrials.client.console.Console;
import org.codetrials.client.console.ConsoleMessage;
import org.codetrials.client.console.ConsoleReporter;
import org.codetrials.client.core.events.EventBus;
import org.codetrials.client.core.events.Handler;
import org.codetrials.client.core.logging.Log;
import org.codetrials.client.core.mvp.BasePresenter;
import org.codetrials.client.core.natives.NativeUtils;
import org.codetrials.client.markdown.Markdown;
import org.codetrials.shared.LayoutConstants;
import org.codetrials.shared.entities.ExecutionResult;
import org.codetrials.shared.entities.Task;
import org.codetrials.shared.entities.Trial;
import org.codetrials.shared.service.GWTRPCServiceAsync;

/**
 * @author Nikita Zyulyaev
 */
class TrialPresenterImpl extends BasePresenter<TrialView> implements TrialPresenter {
    @Inject
    private GWTRPCServiceAsync service;

    private Trial currentTrial;
    private Task currentTask;
    private Console console;

    private final AsyncCallback<Task> currentTaskCallback = new AsyncCallback<Task>() {
        @Override
        public void onFailure(Throwable caught) {
            Log.error(caught);
        }

        @Override
        public void onSuccess(Task task) {
            onTaskChange(task);
        }
    };

    private final CommandHandler commandHandler = new CommandHandler() {
        @Override
        public void handle(String line, final ConsoleReporter reporter) {
            service.execute(currentTrial.getId(), line, new AsyncCallback<ExecutionResult>() {
                @Override
                public void onFailure(Throwable caught) {
                    Log.error(caught);
                }

                @Override
                public void onSuccess(ExecutionResult result) {
                    if (result.isCommandFinished()) {
                        console.setPromptContinued(false);
                        reporter.report(NativeUtils.listOf(
                                ConsoleMessage.of(result.getOutput(), LayoutConstants.CONSOLE_OUTPUT_CLASS),
                                ConsoleMessage.of(result.getError(), LayoutConstants.CONSOLE_ERROR_CLASS)
                        ));
                    } else {
                        console.setPromptContinued(true);
                    }
                }
            });
        }
    };

    @Inject
    TrialPresenterImpl(final TrialView view, EventBus bus) {
        super(view);

        bus.subscribe(ContentManager.SHOW_TRIAL, new Handler<Trial>() {
            @Override
            public void handle(Trial event) {
                onTrialChange(event);
            }
        });
    }

    private void onTrialChange(Trial trial) {
        this.currentTrial = trial;
        service.getCurrentTask(trial.getId(), currentTaskCallback);
        this.console = view.initConsole()
                            .setAutofocus(true)
                            .setPromptLabel(">>> ")
                            .setContinuedPromptLabel("... ")
                            .setCommandHandler(commandHandler)
                            .build();
    }

    private void onTaskChange(Task task) {
        this.currentTask = task;
        view.setTaskLegend(task.getTitle(), Markdown.convert(task.getDescription()));
    }
}
