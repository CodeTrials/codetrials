package org.codetrials.server.service;

import org.codetrials.bundle.BundleContainer;
import org.codetrials.bundle.helpers.ResourceLoader;
import org.codetrials.server.exceptions.InvalidBundleException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * @author Polyarnyi Nikolay
 */
public class BundleLoader {

    private static final String BUNDLE_CONTAINER_MANIFEST_ATTRIBUTE = "Bundle";

    private static final String BUNDLES_FOLDER = "bundles/";
    private static final String BUNDLE_JAR_NAME = "bundle.jar";

    private static final String BUNDLE_TASK_FOLDER = "tasks";
    private static final String BUNDLE_TASK_FILENAME = "slides.txt";

    Map<Integer, Class<BundleContainer>> cachedClasses;

    public BundleLoader() {
        this.cachedClasses = new HashMap<>();
    }

    public BundleContainer createBundleContainer(URL bundlesRoot, int id) throws InvalidBundleException {
        Class<BundleContainer> bundleClass = cachedClasses.get(id);
        if (bundleClass == null) {
            try {
                URL pathToJar = null;
                pathToJar = new URL(bundlesRoot, id + "/" + BUNDLE_JAR_NAME);
                JarFile jar = new JarFile(pathToJar.getFile());
                Manifest manifest = jar.getManifest();
                Attributes attributes = manifest.getMainAttributes();
                String className = attributes.getValue(BUNDLE_CONTAINER_MANIFEST_ATTRIBUTE);
                ClassLoader classLoader = new URLClassLoader(new URL[]{new URL("jar", "", pathToJar + "!/")});
                bundleClass = (Class<BundleContainer>) classLoader.loadClass(className);
                cachedClasses.put(id, bundleClass);
            } catch (MalformedURLException e) {
                throw new InvalidBundleException("Bad url was not found!", e);
            } catch (ClassNotFoundException e) {
                throw new InvalidBundleException("Bundle class was not found!", e);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            BundleContainer bundleContainer = bundleClass.newInstance();
            bundleContainer.setResourceLoader(new ResourceLoader(new URL(bundlesRoot, id + "/" + BUNDLE_TASK_FOLDER + "/"), BUNDLE_TASK_FILENAME));
            bundleContainer.initTasks();
            return bundleContainer;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new InvalidBundleException("Bundle instantiation failure!", e);
        } catch (MalformedURLException e) {
            throw new InvalidBundleException("Bad url for bundle task folder!", e);
        }
    }

}