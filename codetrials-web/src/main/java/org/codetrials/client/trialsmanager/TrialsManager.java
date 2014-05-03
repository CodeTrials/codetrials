package org.codetrials.client.trialsmanager;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.codetrials.client.core.events.EventBus;
import org.codetrials.client.core.events.EventType;
import org.codetrials.client.core.events.Handler;
import org.codetrials.client.core.natives.JsList;
import org.codetrials.shared.entities.Trial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Zyulyaev
 */
@Singleton
public class TrialsManager {
    public static final EventType<Trial> NEW_TRIAL = new EventType<>("NEW_TRIAL");

    private final List<Trial> trials = new ArrayList<>();

    @Inject
    public TrialsManager(EventBus bus) {
        getTrialsFromWindow().forEach(new JsList.Applier<JsTrial>() {
            @Override
            public void apply(JsTrial element, int index, JsList<? extends JsTrial> list) {
                trials.add(element.toTrial());
            }
        });

        bus.subscribe(NEW_TRIAL, new Handler<Trial>() {
            @Override
            public void handle(Trial event) {
                trials.add(event);
            }
        });
    }

    public List<? extends Trial> getTrials() {
        return trials;
    }

    private static native JsList<JsTrial> getTrialsFromWindow() /*-{
        return $wnd.trials || [];
    }-*/;
}
