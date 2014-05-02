package org.codetrials.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

/**
 * @author Nikita Zyulyaev
 */
public class CodeTrialsEntryPoint implements EntryPoint {
    private static final CodeTrialsGin GIN = GWT.create(CodeTrialsGin.class);

    @Override
    public void onModuleLoad() {
        GIN.initLayout();
    }
}
