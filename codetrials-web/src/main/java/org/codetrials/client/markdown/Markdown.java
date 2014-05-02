package org.codetrials.client.markdown;

import com.google.gwt.core.client.JavaScriptObject;

/**
 * @author Nikita Zyulyaev
 */
public final class Markdown {
    private static JavaScriptObject converter = createConverter();

    private Markdown() {}

    public static String convert(String markdown) {
        return convertNative(converter, markdown);
    }

    private static native String convertNative(JavaScriptObject converter, String markdown) /*-{
        return converter.makeHtml(markdown);
    }-*/;

    private static native JavaScriptObject createConverter() /*-{
        return new $wnd.Markdown.Converter();
    }-*/;
}
