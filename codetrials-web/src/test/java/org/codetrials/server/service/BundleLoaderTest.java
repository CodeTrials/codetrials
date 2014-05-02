package org.codetrials.server.service;

import org.codetrials.bundle.BundleContainer;
import org.codetrials.bundle.entities.CommandOutput;
import org.codetrials.bundle.entities.TaskDescription;
import org.junit.Assert;
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
        Assert.assertEquals("5\n", output.getResult().getExecutionOutput());

        desc = bundle.getTaskDescription();
        Assert.assertEquals("Summary", desc.getTitle());
        Assert.assertEquals("Show us your skills, in summing two numbers", desc.getDescription());

        output = bundle.processCommand("adasdas 5+1");
        Assert.assertNotNull(output.getResult().getException());

        output = bundle.processCommand("2 +4");
        Assert.assertEquals("6\n", output.getResult().getExecutionOutput());
    }

}
