package org.codetrials.bundle.helpers.tasks;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.codetrials.bundle.entities.TaskDescription;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * To load text description of tasks. That at first line contains title, and from second line - description.
 *
 * @author Polyarnyi Nikolay
 */
public class ResourceLoader {

    private final String prefix;
    private final String suffix;

    /**
     * For example you want to load files from typical java resources folder: "task_1.txt", "task_2.txt", "task_3.txt".
     *
     * @param prefix for example: "task_"
     * @param suffix for example: ".txt"
     */
    public ResourceLoader(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public TaskDescription loadTaskDescription(int index) throws IOException {
        URL url = new File(prefix + index + suffix).toURI().toURL();
        String text = Resources.toString(url, getEncoding());
        int firstLineEnd = text.indexOf('\n');
        return new TaskDescription(text.substring(0, firstLineEnd), text.substring(firstLineEnd + 1));
    }

    protected Charset getEncoding() {
        return Charsets.UTF_8;
    }

}
