package org.codetrials.client.core.util;

/**
 * @author Nikita Zyulyaev
 */
public interface Transformer<F, T> {
    T transform(F value);
}
