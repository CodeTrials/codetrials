package org.codetrials.client.core.logging;

import com.google.gwt.core.client.GWT;
import org.codetrials.client.core.natives.JsList;

/**
 * @author Nikita Zyulyaev
 */
public final class Log {
    private static final Logger logger = GWT.create(Logger.class);

    private Log() {}

    public static void log(Object message) {
        logger.log(message);
    }

    public static void info(Object message) {
        logger.warn(message);
    }

    public static void warn(Object message) {
        logger.warn(message);
    }

    public static void error(Object message) {
        logger.error(message);
    }

    public static void log(JsList<?> messages) {
        logger.log(messages);
    }

    public static void info(JsList<?> messages) {
        logger.info(messages);
    }

    public static void warn(JsList<?> messages) {
        logger.warn(messages);
    }

    public static void error(JsList<?> messages) {
        logger.error(messages);
    }
}
