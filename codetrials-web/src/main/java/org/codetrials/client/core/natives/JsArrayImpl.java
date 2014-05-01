package org.codetrials.client.core.natives;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.Comparator;

/**
 * @author Nikita Zyulyaev
 */
class JsArrayImpl<E> extends JavaScriptObject implements JsArray<E> {
    protected JsArrayImpl() {
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
    public final native JsArray<E> concat(JsArray<? extends E> list) /*-{
        return this.concat(list);
    }-*/;

    @Override
    public final native boolean every(Filter<? super E> filter) /*-{
        return this.every(filter.@org.codetrials.client.core.natives.JsArray.Filter::apply(Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsArray;));
    }-*/;

    @Override
    public final native JsArray<E> filter(Filter<? super E> filter) /*-{
        return this.filter(filter.@org.codetrials.client.core.natives.JsArray.Filter::apply(Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsArray;));
    }-*/;

    @Override
    public final native void forEach(Applier<? super E> applier) /*-{
        return this.forEach(applier.@org.codetrials.client.core.natives.JsArray.Applier::apply(Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsArray;));
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
    public final native <T> JsArray<T> map(Mapper<? super E, T> mapper) /*-{
        return this.map(mapper.@org.codetrials.client.core.natives.JsArray.Mapper::apply(Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsArray;));
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
    public final native E reduce(Reducer<? super E, ? super E> reducer) /*-{
        return this.reduce(reducer.@org.codetrials.client.core.natives.JsArray.Reducer::apply(Ljava/lang/Object;Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsArray;));
    }-*/;

    @Override
    public final native <T> T reduce(Reducer<? super E, T> reducer, T initialValue) /*-{
        return this.reduce(reducer.@org.codetrials.client.core.natives.JsArray.Reducer::apply(Ljava/lang/Object;Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsArray;), initialValue);
    }-*/;

    @Override
    public final native E reduceRight(Reducer<? super E, ? super E> reducer) /*-{
        return this.reduceRight(reducer.@org.codetrials.client.core.natives.JsArray.Reducer::apply(Ljava/lang/Object;Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsArray;));
    }-*/;

    @Override
    public final native <T> T reduceRight(Reducer<? super E, T> reducer, T initialValue) /*-{
        return this.reduceRight(reducer.@org.codetrials.client.core.natives.JsArray.Reducer::apply(Ljava/lang/Object;Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsArray;), initialValue);
    }-*/;

    @Override
    public final native JsArray<E> reverse() /*-{
        return this.reverse();
    }-*/;

    @Override
    public final native E shift() /*-{
        return this.shift();
    }-*/;

    @Override
    public final native JsArray<E> slice(int begin) /*-{
        return this.slice(begin);
    }-*/;

    @Override
    public final native JsArray<E> slice(int begin, int end) /*-{
        return this.slice(begin, end);
    }-*/;

    @Override
    public final native boolean some(Filter<? super E> filter) /*-{
        return this.some(filter.@org.codetrials.client.core.natives.JsArray.Filter::apply(Ljava/lang/Object;ILorg/codetrials/client/core/natives/JsArray;));
    }-*/;

    @Override
    public final native JsArray<E> sort(Comparator<? super E> comparator) /*-{
        return this.sort(comparator.@java.util.Comparator::compare(Ljava/lang/Object;Ljava/lang/Object;));
    }-*/;

    @Override
    public final native JsArray<E> splice(int index, int length) /*-{
        return this.splice(index, length);
    }-*/;

    @Override
    public final native int unshift(E element) /*-{
        return this.unshift(element);
    }-*/;
}
