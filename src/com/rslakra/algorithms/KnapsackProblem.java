package com.rslakra.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The knapsack problem or rucksack problem is a problem in combinatorial
 * optimization: Given a set of items, each with a weight and a value, determine
 * the number of each item to include in a collection so that the total weight
 * is less than or equal to a given limit and the total value is as large as
 * possible.
 * 
 * https://en.wikipedia.org/wiki/Knapsack_problem
 * 
 * @author Rohtash Singh Lakra
 * @date 11/03/2016 02:29:27 PM
 *
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
	 * 
	 * @param items
	 * @param item
	 * @return
	 */
	public List<Item> solveKnapsackProblem(List<Item> items, Item item) {
		return null;
	}
	
	/**
	 * 
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
