/******************************************************************************
 * Copyright (C) Devamatre Inc 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code, in source
 * and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
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
package com.devamatre.theorem.adts.stack;

import java.util.ArrayList;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2017-12-28 05:47:05 PM
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class ListStack<E> extends ArrayList<E> implements Stack<E> {

    public ListStack() {
        super();
    }

    /**
     * @param item
     * @return
     * @see com.devamatre.coder.stack.Stack#push(java.lang.Object)
     */
    @Override
    public E push(E item) {
        super.add(0, item);
        return item;
    }

    /**
     * @param item
     * @return
     * @see java.util.ArrayList#add(java.lang.Object)
     */
    public boolean add(E item) {
        super.add(0, item);
        return true;
    }

    /**
     * @return
     * @see com.devamatre.coder.stack.Stack#pop()
     */
    @Override
    public E pop() {
        return remove(0);
    }

    /**
     * @return
     * @see com.devamatre.coder.stack.Stack#peek()
     */
    @Override
    public E peek() {
        return get(0);
    }

    /**
     * @return
     * @see com.devamatre.coder.stack.Stack#empty()
     */
    @Override
    public boolean empty() {
        return super.isEmpty();
    }

    /**
     * @return
     * @see java.util.ArrayList#size()
     */
    public int size() {
        return super.size();
    }

    /**
     * @param item
     * @return
     * @see java.util.ArrayList#contains(java.lang.Object)
     */
    public boolean contains(Object item) {
        return super.contains(item);
    }

}
