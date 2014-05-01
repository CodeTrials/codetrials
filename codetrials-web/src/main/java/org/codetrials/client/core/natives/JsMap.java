package org.codetrials.client.core.natives;

import com.google.gwt.core.client.SingleJsoImpl;

/**
 * @author Nikita Zyulyaev
 */
@SingleJsoImpl(JsMapImpl.class)
public interface JsMap<V> {
    V get(String key);
    void put(String key, V value);
    void remove(String key);
    boolean containsKey(String key);

    JsArray<String> keys();
}
