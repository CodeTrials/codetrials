package org.codetrials.server.config;

import org.apache.commons.io.IOUtils;
import org.codetrials.server.service.dao.BundleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * @author Nikita Zyulyaev
 */
@Component
public class DataBaseInitializer {
    @Autowired
    public void initBundleDao(BundleDAO bd) {
        try {
            addJavaScriptTutorial(bd);
            addPythonSandbox(bd);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private void addJavaScriptTutorial(BundleDAO bd) throws IOException {
        URL url = getClass().getClassLoader().getResource("javascriptBundle.jar");

        if (url == null) {
            throw new IllegalStateException("Default bundle not found!");
        }

        File file = new File(url.getFile());
        byte[] fileBytes = IOUtils.toByteArray(new FileInputStream(file));
        bd.addBundle("JavaScript", fileBytes);
    }

    private void addPythonSandbox(BundleDAO bd) throws IOException {
        URL url = getClass().getClassLoader().getResource("pythonSandboxBundle.jar");

        if (url == null) {
            throw new IllegalStateException("Default bundle not found!");
        }

        File file = new File(url.getFile());
        byte[] fileBytes = IOUtils.toByteArray(new FileInputStream(file));
        bd.addBundle("Python", fileBytes);
    }
}
