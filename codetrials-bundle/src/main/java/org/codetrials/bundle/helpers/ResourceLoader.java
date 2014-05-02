package org.codetrials.bundle.helpers;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import org.codetrials.bundle.entities.TaskDescription;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * To load text description of tasks. That at first line contains title, and from second line - description.
 *
 * @author Polyarnyi Nikolay
 */
public class ResourceLoader {

    private final URL rootToTests;
    private final String filename;
//    private final String prefix;
//    private final String suffix;

    private ArrayList<TaskDescription> descriptions;

    /*
    public ResourceLoader(URL rootToTests, String prefix, String suffix) {
        this.rootToTests = rootToTests;
        this.prefix = prefix;
        this.suffix = suffix;
    }
    */

    public ResourceLoader(URL rootToTests, String filename) {
        this.rootToTests = rootToTests;
        this.filename = filename;
        try {
            loadDescriptions();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void loadDescriptions() throws IOException {
        URL url = new URL(rootToTests, filename);
        String text = Resources.toString(url, getEncoding());
        List<String> tasks = divideByEquals(text);
        descriptions = new ArrayList<>();
        for (int i = 0; i < tasks.size(); ++i) {
            String task = tasks.get(i);
            int firstLineEnd = task.indexOf('\n');
            descriptions.add(new TaskDescription(
                    task.substring(0, firstLineEnd), task.substring(firstLineEnd + 1), i));
        }
    }

    public TaskDescription loadTaskDescription(int index) throws IOException {
        return descriptions.get(index);
    }

    protected Charset getEncoding() {
        return Charsets.UTF_8;
    }

    private static List<String> divideByEquals(String text) {
        List<String> ans = new ArrayList<>();
        int idx = 0;
        while (idx < text.length()) {
            int pos = text.indexOf("====", idx);
            if (pos < 0) {
                pos = text.length();
            }
            ans.add(text.substring(idx, pos));
            idx = pos;
            while (idx < text.length() && text.charAt(idx) == '=') {
                idx++;
            }
            while (idx < text.length() && Character.isWhitespace(text.charAt(idx))) {
                idx++;
            }
        }
        return ans;
    }

}
