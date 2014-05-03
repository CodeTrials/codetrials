package org.codetrials.bundle.engines;

import java.util.StringTokenizer;

/**
 * Created by vlpolyansky.
 */
public class RubyEngine extends StandardEngine {

    public RubyEngine() {
        super("jruby");
    }

    protected boolean updateBalance(String command) {
        command = command.substring(0, (command + '#').indexOf('#'));
        String[] beginnings = {"do", "def", "begin", "if", "{"};
        String[] endings = {"end", "}"};
        StringBuilder specSymbols = new StringBuilder();
        for (char c = 32; c < 256; ++c) {
            if (!(c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <='Z')) {
                specSymbols.append(c);
            }
        }
        StringTokenizer tokenizer = new StringTokenizer(command, specSymbols.toString(), true);
        boolean inside = false;
        String stringSym = "";
        while (tokenizer.hasMoreElements()) {
            String elem = tokenizer.nextToken();
            if ("\"".equals(elem) || "'".equals(elem)) {
                if (inside && stringSym.equals(elem)) {
                    inside = false;
                } else if (!inside) {
                    inside = true;
                    stringSym = elem;
                }
            } else {
                for (String beg : beginnings) {
                    if (beg.equals(elem)) {
                        balance++;
                    }
                }
                for (String end : endings) {
                    if (end.equals(elem)) {
                        balance--;
                        if (balance < 0) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
