package org.codetrials.server.service;

import org.codetrials.bundle.BundleContainer;
import org.codetrials.bundle.helpers.tasks.ResourceLoader;
import org.codetrials.server.exceptions.MissingBundleAttributeException;
import org.codetrials.server.utils.JarFileClassLoader;

import java.io.File;
import java.io.IOException;
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

    private static final String BUNDLE_TASK_FOLDER = "task";
    private static final String BUNDLE_TASK_PREFIX = "task_";
    private static final String BUNDLE_TASK_SUFFIX = ".txt";

    Map<Integer, Class<BundleContainer>> cachedClasses;

    public BundleLoader() {
        this.cachedClasses = new HashMap<>();
    }

    public BundleContainer createBundleContainer(int id) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, MissingBundleAttributeException {
        Class<BundleContainer> bundleClass = cachedClasses.get(id);
        if (bundleClass == null) {
            String pathToJar = BUNDLES_FOLDER + id + "/" + BUNDLE_JAR_NAME;
            JarFile jar = new JarFile(new File(pathToJar));
            Manifest manifest = jar.getManifest();
            Attributes attributes = manifest.getMainAttributes();
            String className = attributes.getValue(BUNDLE_CONTAINER_MANIFEST_ATTRIBUTE);
            JarFileClassLoader classLoader = new JarFileClassLoader(pathToJar);
            bundleClass = (Class<BundleContainer>) classLoader.loadClass(className);
            cachedClasses.put(id, bundleClass);
        }
        BundleContainer bundleContainer = bundleClass.newInstance();
        bundleContainer.setResourceLoader(new ResourceLoader(BUNDLES_FOLDER + id + "/" + BUNDLE_TASK_FOLDER + "/" + BUNDLE_TASK_PREFIX, BUNDLE_TASK_SUFFIX));
        return bundleContainer;
    }

}