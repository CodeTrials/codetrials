package org.codetrials.client.trialform;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.Widget;
import org.codetrials.client.core.mvp.BaseView;
import org.codetrials.shared.LayoutConstants;

/**
 * @author Nikita Zyulyaev
 */
class TrialFormViewImpl extends BaseView<TrialFormPresenter> implements TrialFormView {
    interface TrialFormViewUiBinder extends UiBinder<Widget, TrialFormViewImpl> {}
    private static final TrialFormViewUiBinder UI_BINDER = GWT.create(TrialFormViewUiBinder.class);
    @UiField
    FormPanel form;
    @UiField
    FileUpload file;

    TrialFormViewImpl() {
        initWidget(UI_BINDER.createAndBindUi(this));

        form.setAction(LayoutConstants.BUNDLE_UPLOAD_FORM_URL);
        form.setMethod(FormPanel.METHOD_POST);
        form.setEncoding(FormPanel.ENCODING_MULTIPART);
        form.addSubmitHandler(new FormPanel.SubmitHandler() {
            @Override
            public void onSubmit(FormPanel.SubmitEvent event) {
                if (file.getFilename() == null) {
                    event.cancel();
                }
            }
        });
        form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                presenter.onBundleUploaded(event.getResults());
            }
        });
    }
}
