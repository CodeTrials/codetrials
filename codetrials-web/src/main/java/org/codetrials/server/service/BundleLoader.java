package org.codetrials.server.service;

import org.codetrials.bundle.BundleContainer;
import org.codetrials.server.exceptions.MissingBundleAttributeException;
import org.codetrials.server.utils.JarFileClassLoader;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * @author Polyarnyi Nikolay
 */
public class BundleLoader {

    private static final String BUNDLE_CONTAINER_MANIFEST_ATTRIBUTE = "Bundle-Container";

    Map<String, JarFileClassLoader> classLoaders;

    public BundleLoader() {
        this.classLoaders = new HashMap<>();
    }

    public BundleContainer createBundleContainer(URL pathToJar) throws IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, MissingBundleAttributeException {
        JarFileClassLoader classLoader = classLoaders.get(pathToJar);
        if (classLoader == null) {
            classLoader = new JarFileClassLoader(pathToJar);
            classLoaders.put(pathToJar.toString(), classLoader);
        }
        URL manifestUrl = classLoader.getResource("META-INF/MANIFEST.MF");
        if (manifestUrl == null) {
            throw new MissingBundleAttributeException();
        }
        Manifest manifest = new Manifest(manifestUrl.openStream());
        Attributes attributes = manifest.getAttributes(BUNDLE_CONTAINER_MANIFEST_ATTRIBUTE);
        String className = attributes.getValue(BUNDLE_CONTAINER_MANIFEST_ATTRIBUTE);
        Class bundleClass = classLoader.loadClass(className);
        return (BundleContainer) bundleClass.newInstance();
    }

}