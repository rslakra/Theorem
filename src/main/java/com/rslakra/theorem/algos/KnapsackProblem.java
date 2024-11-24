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
package com.rslakra.theorem.algos;

import java.util.ArrayList;
import java.util.List;

/**
 * The knapsack problem or rucksack problem is a problem in combinatorial optimization: Given a set of items, each with
 * a weight and a value, determine the number of each item to include in a collection so that the total weight is less
 * than or equal to a given limit and the total value is as large as possible.
 * <p>
 * https://en.wikipedia.org/wiki/Knapsack_problem
 *
 * @author Rohtash Lakra
 * @created 11/03/2016 02:29:27 PM
 */
public class KnapsackProblem {

    static final class Item {

        final int weight;
        final int value;

        public Item(final int weight, final int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    /**
     * @param items
     * @param item
     * @return
     */
    public List<Item> solveKnapsackProblem(List<Item> items, Item item) {
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        KnapsackProblem kProblem = new KnapsackProblem();
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(2, 1));
        items.add(new Item(6, 7));
        items.add(new Item(3, 8));
        items.add(new Item(3, 3));
        items.add(new Item(1, 4));
        items.add(new Item(6, 1));
        Item item = new Item(20, 10);
        List<Item> result = kProblem.solveKnapsackProblem(items, item);
        System.out.println(result);

    }

}
