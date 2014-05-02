package org.codetrials.server.service;

import org.codetrials.bundle.BundleContainer;
import org.codetrials.server.exceptions.MissingBundleAttributeException;
import org.codetrials.server.utils.JarFileClassLoader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.Enumeration;
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

    Map<String, Class<BundleContainer>> cachedClasses;

    public BundleLoader() {
        this.cachedClasses = new HashMap<>();
    }

    public BundleContainer createBundleContainer(URL pathToJar) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, MissingBundleAttributeException {
        Class<BundleContainer> bundleClass = cachedClasses.get(pathToJar.toString());
        if (bundleClass == null) {
            JarFile jar = new JarFile(new File(pathToJar.getFile()));
            Manifest manifest = jar.getManifest();
            Attributes attributes = manifest.getAttributes(BUNDLE_CONTAINER_MANIFEST_ATTRIBUTE);
            String className = attributes.getValue(BUNDLE_CONTAINER_MANIFEST_ATTRIBUTE);
            JarFileClassLoader classLoader = new JarFileClassLoader(pathToJar);
            bundleClass = (Class<BundleContainer>) classLoader.loadClass(className);
            cachedClasses.put(pathToJar.toString(), bundleClass);
        }
        return bundleClass.newInstance();
    }

}