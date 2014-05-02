package org.codetrials.server.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Polyarnyi Nikolay
 */
public class JarFileClassLoader extends URLClassLoader {

    public JarFileClassLoader(URL pathToJar) throws MalformedURLException {
        super(new URL[]{new URL("jar:file://" + pathToJar.toString() + "!/")});
    }

}
