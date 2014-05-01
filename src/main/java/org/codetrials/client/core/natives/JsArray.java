package org.codetrials.client.core.natives;

import com.google.gwt.core.client.SingleJsoImpl;

import java.util.Comparator;

/**
 * Not user-friendly JsArray interface
 * @author Nikita Zyulyaev
 */
@SingleJsoImpl(JsArrayImpl.class)
public interface JsArray<E> {
    int length();
    void setLength(int length);
    E get(int index);
    void set(int index, E element);

    JsArray<E> concat(JsArray<? extends E> list); // todo vararg
    boolean every(Filter<? super E> filter);
    JsArray<E> filter(Filter<? super E> filter);
    void forEach(Applier<? super E> applier);
    int indexOf(Object element);
    int indexOf(Object element, int fromIndex);
    String join(String separator);
    int lastIndexOf(Object element);
    int lastIndexOf(Object element, int fromIndex);
    <T> JsArray<T> map(Mapper<? super E, T> mapper);
    E pop();
    int push(E element); // todo vararg
    E reduce(Reducer<? super E, ? super E> reducer);
    <T> T reduce(Reducer<? super E, T> reducer, T initialValue);
    E reduceRight(Reducer<? super E, ? super E> reducer);
    <T> T reduceRight(Reducer<? super E, T> reducer, T initialValue);
    JsArray<E> reverse();
    E shift();
    JsArray<E> slice(int begin);
    JsArray<E> slice(int begin, int end);
    boolean some(Filter<? super E> filter);
    JsArray<E> sort(Comparator<? super E> comparator); // todo null acceptable
    JsArray<E> splice(int index, int length); // todo vararg
    int unshift(E element); // todo vararg

    interface Filter<E> {
        boolean apply(E element, int index, JsArray<? extends E> list);
    }

    interface Applier<E> {
        void apply(E element, int index, JsArray<? extends E> list);
    }

    interface Mapper<E, T> {
        T apply(E element, int index, JsArray<? extends E> list);
    }

    interface Reducer<E, T> {
        T apply(T previousValue, E element, int index, JsArray<? extends E> list);
    }
}
