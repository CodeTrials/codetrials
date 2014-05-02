package org.codetrials.server.service;

import org.codetrials.bundle.BundleContainer;
import org.codetrials.bundle.helpers.ResourceLoader;
import org.codetrials.server.exceptions.InvalidBundleException;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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

    public static final String BUNDLE_CONTAINER_MANIFEST_ATTRIBUTE = "Bundle";

    public static final String BUNDLES_FOLDER = "bundles/";
    public static final String BUNDLE_JAR_NAME = "bundle.jar";

    public static final String BUNDLE_TASK_FOLDER = "tasks";
    public static final String BUNDLE_TASK_FILENAME = "slides.txt";

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
                if (id != -1) {
                    cachedClasses.put(id, bundleClass);
                }
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

    public boolean validateContainer(byte[] bytes) {
        try {
            File tmp = saveAsTmp(bytes);
            URL pathToJar = tmp.toURI().toURL();
            JarFile jar = new JarFile(pathToJar.getFile());
            Manifest manifest = jar.getManifest();
            Attributes attributes = manifest.getMainAttributes();
            String className = attributes.getValue(BUNDLE_CONTAINER_MANIFEST_ATTRIBUTE);
            ClassLoader classLoader = new URLClassLoader(new URL[]{new URL("jar", "", pathToJar + "!/")});
            Class<BundleContainer> bundleClass = (Class<BundleContainer>) classLoader.loadClass(className);

            tmp.delete();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private File saveAsTmp(byte[] bytes) throws IOException {
        File tmp = File.createTempFile("BULLSHIT", null);
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(tmp));) {
            bos.write(bytes);
            bos.flush();
        }
        return tmp;
    }

}