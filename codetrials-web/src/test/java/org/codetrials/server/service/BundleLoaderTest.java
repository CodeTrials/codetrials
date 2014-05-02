package org.codetrials.server.service;

import com.google.common.io.Resources;
import org.junit.Assert;
import org.codetrials.bundle.BundleContainer;
import org.junit.Test;

/**
 * @author Polyarnyi Nikolay
 */
public class BundleLoaderTest {

    @Test
    public void testBundleLoading() throws Exception {
        BundleLoader loader = new BundleLoader();
        BundleContainer bundle = loader.createBundleContainer(Resources.getResource("javascript-tutorial-bundle-1.0-SNAPSHOT.jar"));
        Assert.assertEquals("", bundle.getBundleName());
    }

}
