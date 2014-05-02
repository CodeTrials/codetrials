package org.codetrials.client.core.natives;

import com.google.gwt.core.client.SingleJsoImpl;

import java.util.Comparator;

/**
 * Not user-friendly JsArray interface
 * @author Nikita Zyulyaev
 */
@SingleJsoImpl(JsListImpl.class)
public interface JsList<E> {
    int length();
    void setLength(int length);
    E get(int index);
    void set(int index, E element);

    JsList<E> concat(JsList<? extends E> list); // todo vararg
    boolean every(Filter<? super E> filter);
    JsList<E> filter(Filter<? super E> filter);
    void forEach(Applier<? super E> applier);
    int indexOf(Object element);
    int indexOf(Object element, int fromIndex);
    String join(String separator);
    int lastIndexOf(Object element);
    int lastIndexOf(Object element, int fromIndex);
    <T> JsList<T> map(Mapper<? super E, T> mapper);
    E pop();
    int push(E element); // todo vararg
    JsList<E> reverse();
    E shift();
    JsList<E> slice(int begin);
    JsList<E> slice(int begin, int end);
    boolean some(Filter<? super E> filter);
    JsList<E> sort(Comparator<? super E> comparator); // todo null acceptable
    JsList<E> splice(int index, int length); // todo vararg
    int unshift(E element); // todo vararg

    Iterable<E> asIterable();

    interface Filter<E> {
        boolean apply(E element, int index, JsList<? extends E> list);
    }

    interface Applier<E> {
        void apply(E element, int index, JsList<? extends E> list);
    }

    interface Mapper<E, T> {
        T apply(E element, int index, JsList<? extends E> list);
    }
}
