/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license 
 * agreements. The reproduction, transmission or use of this code, in source 
 * and binary forms, with or without modification, are permitted provided 
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright
 * 	  notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE AUTHOR OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS
 * OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 *
 * Devamatre reserves the right to modify the technical specifications and or 
 * features without any prior notice.
 *****************************************************************************/
package com.rslakra.theorem.adts.hash;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-07 03:36:09 PM
 * @since 1.0.0
 */
public class HashTableTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HashTableTest.class);

    /**
     * Tests the <code>hashTable</code>.
     */
    @Test
    public void testHashTable() {
        HashTable<Integer, Integer> hashTable = new HashTable<>();
        assertNotNull(hashTable);
        assertEquals(0, hashTable.size());
        LOGGER.debug("hashTable:{}", hashTable);
        assertNull(hashTable.get(1));

        // add entries in hashTable.
        hashTable.put(1, 11);
        hashTable.put(2, 12);
        hashTable.put(3, 13);
        hashTable.put(4, 14);
        LOGGER.debug("hashTable:{}", hashTable);
        assertEquals(4, hashTable.size());
        assertEquals(11, hashTable.get(1));
        assertEquals(12, hashTable.get(2));

        // remove entries from hash map.
        Integer removed = hashTable.remove(3);
        assertNotNull(removed);
        LOGGER.debug("removed:{}, hashTable:{}", removed, hashTable);
        assertEquals(3, hashTable.size());
    }

}
