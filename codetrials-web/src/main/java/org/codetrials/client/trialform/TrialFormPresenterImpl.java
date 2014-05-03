package org.codetrials.client.trialform;

import com.google.gwt.json.client.JSONBoolean;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONParser;
import com.google.gwt.json.client.JSONString;
import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import org.codetrials.client.core.events.EventBus;
import org.codetrials.client.core.logging.Log;
import org.codetrials.client.core.mvp.BasePresenter;
import org.codetrials.client.trialsmanager.JsTrial;
import org.codetrials.client.trialsmanager.TrialsManager;

/**
 * @author Nikita Zyulyaev
 */
class TrialFormPresenterImpl extends BasePresenter<TrialFormView> implements TrialFormPresenter {
    @Inject
    EventBus bus;

    @Inject
    TrialFormPresenterImpl(TrialFormView view) {
        super(view);
    }

    @Override
    public void onBundleUploaded(String results) {
        JSONObject result = (JSONObject) JSONParser.parseStrict(results);
        boolean success = ((JSONBoolean) result.get("success")).booleanValue();
        if (success) {
            JSONObject jsTrial = ((JSONObject) result.get("newTrial"));
            bus.fire(TrialsManager.NEW_TRIAL, jsTrial.getJavaScriptObject().<JsTrial>cast().toTrial());
        } else {
            JSONString message = (JSONString) result.get("message");
            Window.alert(message.stringValue());
            Log.warn(message.stringValue());
        }
    }
}
