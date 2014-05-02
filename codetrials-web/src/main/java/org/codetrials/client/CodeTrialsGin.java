package org.codetrials.client;

import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.inject.client.NoGinModules;

/**
 * @author Nikita Zyulyaev
 */
@NoGinModules
public interface CodeTrialsGin extends Ginjector {
    LayoutInitializer initLayout();
}
