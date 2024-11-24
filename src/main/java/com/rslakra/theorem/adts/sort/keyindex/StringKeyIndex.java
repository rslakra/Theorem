package com.rslakra.theorem.adts.sort.keyindex;

import java.util.HashMap;

/**
 * @author Rohtash Lakra
 * @created 1/6/21 1:53 PM
 */
public abstract class StringKeyIndex<K> extends HashMap<K, Integer> {

    public StringKeyIndex() {
    }

    /**
     * Returns the index of the provided <code>key</code>. If key doesn't exist, it returns -1 as default index.
     *
     * @param key
     * @return
     */
    @Override
    public Integer get(Object key) {
        return super.containsKey(key) ? super.get(key) : -1;
    }
}
