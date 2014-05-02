package org.codetrials.client.core.natives;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.Comparator;
import java.util.Iterator;

/**
 * @author Nikita Zyulyaev
 */
class JsListImpl<E> extends JavaScriptObject implements JsList<E> {
    protected JsListImpl() {
    }

    @Override
    public final native int length() /*-{
        return this.length;
    }-*/;

    @Override
    public final native void setLength(int length) /*-{
        this.length = length;
    }-*/;

    @Override
    public final native E get(int index) /*-{
        return this[index];
    }-*/;

    @Override
    public final native void set(int index, E element) /*-{
        this[index] = element;
    }-*/;

    @Override
    public final native JsList<E> concat(JsList<? extends E> list) /*-{
        return this.concat(list);
    }-*/;

    @Override
    public final native boolean every(Filter<? super E> filter) /*-{
        for (var i = 0, len = this.length; i < len; ++i) {
            if (!filter.@org.codetrials.client.core.natives.JsList.Filter::apply(Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsList;)(this[i], i, this)) {
                return false;
            }
        }
        return true;
    }-*/;

    @Override
    public final native JsList<E> filter(Filter<? super E> filter) /*-{
        var result = [];
        for (var i = 0, len = this.length; i < len; ++i) {
            if (filter.@org.codetrials.client.core.natives.JsList.Filter::apply(Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsList;)(this[i], i, this)) {
                result.push(this[i]);
            }
        }
        return result;
    }-*/;

    @Override
    public final native void forEach(Applier<? super E> applier) /*-{
        for (var i = 0, len = this.length; i < len; ++i) {
            applier.@org.codetrials.client.core.natives.JsList.Applier::apply(Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsList;)(this[i], i, this);
        }
    }-*/;

    @Override
    public final native int indexOf(Object element) /*-{
        return this.indexOf(element);
    }-*/;

    @Override
    public final native int indexOf(Object element, int fromIndex) /*-{
        return this.indexOf(element, fromIndex);
    }-*/;

    @Override
    public final native String join(String separator) /*-{
        return this.join(separator);
    }-*/;

    @Override
    public final native int lastIndexOf(Object element) /*-{
        return this.lastIndexOf(element);
    }-*/;

    @Override
    public final native int lastIndexOf(Object element, int fromIndex) /*-{
        return this.lastIndexOf(element, fromIndex);
    }-*/;

    @Override
    public final native <T> JsList<T> map(Mapper<? super E, T> mapper) /*-{
        var result = [];
        for (var i = 0, len = this.length; i < len; ++i) {
            result.push(mapper.@org.codetrials.client.core.natives.JsList.Mapper::apply(Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsList;)(this[i], i, this));
        }
        return result;
    }-*/;

    @Override
    public final native E pop() /*-{
        return this.pop();
    }-*/;

    @Override
    public final native int push(E element) /*-{
        return this.push(element);
    }-*/;

    @Override
    public final native JsList<E> reverse() /*-{
        return this.reverse();
    }-*/;

    @Override
    public final native E shift() /*-{
        return this.shift();
    }-*/;

    @Override
    public final native JsList<E> slice(int begin) /*-{
        return this.slice(begin);
    }-*/;

    @Override
    public final native JsList<E> slice(int begin, int end) /*-{
        return this.slice(begin, end);
    }-*/;

    @Override
    public final native boolean some(Filter<? super E> filter) /*-{
        for (var i = 0, len = this.length; i < len; ++i) {
            if (filter.@org.codetrials.client.core.natives.JsList.Filter::apply(Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsList;)(this[i], i, this)) {
                return true;
            }
        }
        return false;
    }-*/;

    @Override
    public final native JsList<E> sort(Comparator<? super E> comparator) /*-{
        return this.sort(comparator.@java.util.Comparator::compare(Ljava/lang/Object;Ljava/lang/Object;));
    }-*/;

    @Override
    public final native JsList<E> splice(int index, int length) /*-{
        return this.splice(index, length);
    }-*/;

    @Override
    public final native int unshift(E element) /*-{
        return this.unshift(element);
    }-*/;

    @Override
    public final Iterable<E> asIterable() {
        Iterable<E> stored = getStoredIterable();
        if (stored == null) return storeIterable(new JsIterableList<E>(this));
        return stored;
    }

    private native Iterable<E> getStoredIterable() /*-{
        return this.iterable;
    }-*/;

    private native Iterable<E> storeIterable(Iterable<E> iterable) /*-{
        return this.iterable = iterable;
    }-*/;

    private static class JsIterableList<E> implements Iterable<E> {
        private final JsList<E> list;

        private JsIterableList(JsList<E> list) {
            this.list = list;
        }

        @Override
        public Iterator<E> iterator() {
            return new Iter();
        }

        private class Iter implements Iterator<E> {
            private int index = 0;
            private boolean removed = false;

            @Override
            public boolean hasNext() {
                return index < list.length();
            }

            @Override
            public E next() {
                return list.get(index++);
            }

            @Override
            public void remove() {
                if (!removed) {
                    list.splice(index, 1);
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }
}
