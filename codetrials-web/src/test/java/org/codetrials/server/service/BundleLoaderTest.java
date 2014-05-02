package org.codetrials.server.service;

import com.google.common.io.Resources;
import org.codetrials.bundle.entities.CommandOutput;
import org.codetrials.bundle.entities.TaskDescription;
import org.junit.Assert;
import org.codetrials.bundle.BundleContainer;
import org.junit.Test;

import java.net.URL;

/**
 * @author Polyarnyi Nikolay
 */
public class BundleLoaderTest {

    @Test
    public void testBundleLoading() throws Exception {
        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));
        BundleLoader loader = new BundleLoader();
        URL rootOfBundles = BundleLoaderTest.class.getResource("/bundles/");
        BundleContainer bundle = loader.createBundleContainer(rootOfBundles, 1);
        Assert.assertEquals("JavaScript", bundle.getBundleName());

        TaskDescription desc = bundle.getTaskDescription();
        Assert.assertEquals("Test slide", desc.getTitle());
        Assert.assertEquals("Do some compilable shit", desc.getDescription());

        desc = bundle.getTaskDescription();
        Assert.assertEquals("Test slide", desc.getTitle());
        Assert.assertEquals("Do some compilable shit", desc.getDescription());

        CommandOutput output = bundle.processCommand("asasd");
        Assert.assertNotNull(output.getResult().getException());
        desc = bundle.getTaskDescription();
        Assert.assertEquals("Test slide", desc.getTitle());
        Assert.assertEquals("Do some compilable shit", desc.getDescription());

        output = bundle.processCommand("2+3");
        desc = bundle.getTaskDescription();
        Assert.assertEquals("Summary", desc.getTitle());
        Assert.assertEquals("Show us your skills, in summing two numbers", desc.getDescription());
        output = bundle.processCommand("adasdas");
        output = bundle.processCommand("2 +4");
        int x = 239;
    }

}
