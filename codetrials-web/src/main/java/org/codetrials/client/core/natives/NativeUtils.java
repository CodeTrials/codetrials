package org.codetrials.client.core.natives;

/**
 * @author Nikita Zyulyaev
 */
public final class NativeUtils {
    private NativeUtils() {}

    public static native <E> JsList<E> list() /*-{
        return [];
    }-*/;

    public static native <E> JsList<E> listOf(E e1) /*-{
        return [e1];
    }-*/;

    public static native <E> JsList<E> listOf(E e1, E e2) /*-{
        return [e1, e2];
    }-*/;

    public static native <E> JsList<E> listOf(E e1, E e2, E e3) /*-{
        return [e1, e2, e3];
    }-*/;

    public static native <E> JsList<E> listOf(E e1, E e2, E e3, E e4) /*-{
        return [e1, e2, e3, e4];
    }-*/;

    public static native <E> JsList<E> listOf(E e1, E e2, E e3, E e4, E e5) /*-{
        return [e1, e2, e3, e4, e5];
    }-*/;

    public static native <E> JsList<E> listOf(E e1, E e2, E e3, E e4, E e5, E e6) /*-{
        return [e1, e2, e3, e4, e5, e6];
    }-*/;

    public static native <E> JsList<E> listOf(E e1, E e2, E e3, E e4, E e5, E e6, E e7) /*-{
        return [e1, e2, e3, e4, e5, e6, e7];
    }-*/;

    public static native <V> JsMap<V> map() /*-{
        return Object.create(null);
    }-*/;

    public static native JsBoolean jsBoolean(boolean value) /*-{
        return value;
    }-*/;

    public static native JsInt jsInt(int value) /*-{
        return value;
    }-*/;

    public static native JsDouble jsDouble(double value) /*-{
        return value;
    }-*/;
}
