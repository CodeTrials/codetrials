package org.codetrials.client.trialsmanager;

import com.google.inject.Singleton;
import org.codetrials.client.core.natives.JsList;
import org.codetrials.shared.entities.Trial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nikita Zyulyaev
 */
@Singleton
public class TrialsManager {
    private final List<Trial> trials = new ArrayList<>();

    public TrialsManager() {
        getTrialsFromWindow().forEach(new JsList.Applier<JsTrial>() {
            @Override
            public void apply(JsTrial element, int index, JsList<? extends JsTrial> list) {
                trials.add(new Trial(element.getTitle(), element.getDescription()));
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
