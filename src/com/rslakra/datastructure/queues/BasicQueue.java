package com.rslakra.datastructure.queues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

public class BasicQueue<E> implements Queue<E> {
	
	private List<E> data;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicQueue<Integer> queue = new BasicQueue<>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		System.out.println(queue);
		
		System.out.println(queue.peek());
		queue.remove();
		queue.remove();
		queue.remove();
		System.out.println(queue);
		
		queue.remove();
		
	}
	
	public BasicQueue() {
		data = new ArrayList<>();
	}
	
	/**
	 * 
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return data.size();
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return data.isEmpty();
	}
	
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return data.iterator();
	}
	
	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return data.toArray();
	}
	
	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return data.toArray(a);
	}
	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return data.remove(o);
	}
	
	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return data.addAll(c);
	}
	
	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return data.retainAll(c);
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		data.clear();
	}
	
	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return data.add(e);
	}
	
	@Override
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		return data.add(e);
	}
	
	@Override
	public E remove() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is empty!");
		} else {
			return data.remove(0);
		}
	}
	
	@Override
	public E poll() {
		if(isEmpty()) {
			return null;
		} else {
			return data.remove(0);
		}
	}
	
	@Override
	public E element() {
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is empty!");
		} else {
			return data.get(0);
		}
	}
	
	@Override
	public E peek() {
		if(isEmpty()) {
			return null;
		} else {
			return data.get(0);
		}
	}
	
	public String toString() {
		return data.toString();
	}
	
}
