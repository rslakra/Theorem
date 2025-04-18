package com.rslakra.theorem.adts;

import com.rslakra.theorem.adts.list.List;

/**
 * @author Rohtash Lakra
 * @created 12/21/23 8:33 AM
 */
public interface DataLoader<E> {

    /**
     * Loads the data.
     *
     * @param data
     * @return
     */
    void load(List<E> data);

}
