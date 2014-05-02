package org.codetrials.shared;

/**
 * @author Nikita Zyulyaev
 */
public final class LayoutConstants {
    private LayoutConstants() {}

    public static final String CONTAINER_ID = "container";

    public static final String BUNDLE_UPLOAD_FORM_URL = "bundle/upload";
    public static final String BUNDLE_UPLOAD_FORM_BUNDLE = "bundle";
    public static final String BUNDLE_UPLOAD_FORM_TITLE = "title";

    public static final String CONSOLE_OUTPUT_CLASS = "jquery-console-message-value";
    public static final String CONSOLE_ERROR_CLASS = "jquery-console-message-error";

    public static String bundleUploadFormBundle() {
        return BUNDLE_UPLOAD_FORM_BUNDLE;
    }

    public static String bundleUploadFormTitle() {
        return BUNDLE_UPLOAD_FORM_TITLE;
    }
}
