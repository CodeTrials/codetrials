package org.codetrials.client.core.events;

import org.codetrials.client.core.natives.JsList;
import org.codetrials.client.core.natives.NativeUtils;

/**
 * @author Nikita Zyulyaev
 */
class CopyOnWriteJsList<E> {
    private JsList<E> data;

    CopyOnWriteJsList() {
        data = NativeUtils.list();
    }

    CopyOnWriteJsList(E element) {
        data = NativeUtils.listOf(element);
    }

    void add(E element) {
        copy();
        data.push(element);
    }

    boolean remove(Object element) {
        copy();
        int index = data.indexOf(element);
        if (index != -1) {
            data.splice(index, 1);
            return false;
        }
        return true;
    }

    boolean isEmpty() {
        return data.length() == 0;
    }

    private void copy() {
        data = data.slice(0);
    }

    JsList<E> getData() {
        return data;
    }
}
