package com.rslakra.java.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.rslakra.core.bos.Book;
import com.rslakra.utils.Objects;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 10/18/2016 02:12:13 PM
 *
 */
public final class BookManager implements Cloneable {

	private static BookManager instance;
	private List<Book> books;

	/**
	 * 
	 */
	private BookManager() {
		books = new ArrayList<>();
	}

	/**
	 * 
	 * @return
	 */
	public BookManager getInstance() {
		if (Objects.isNull(instance)) {
			synchronized (BookManager.class) {
				if (Objects.isNull(instance)) {
					instance = new BookManager();
				}
			}
		}

		return instance;
	}

	/**
	 * @see java.lang.Object#clone()
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Cloning is not allowed for this object.");
	}

	/**
	 * 
	 * @param book
	 */
	public void addBook(Book book) {
		if (Objects.isNotNull(book)) {
			books.add(book);
		}
	}

	/**
	 * 
	 * @param book
	 */
	public Book getBook(int index) {
		return books.get(index);
	}

	/**
	 * Returns the list of all books.
	 * 
	 * @param book
	 */
	public List<Book> getBooks(int index) {
		return Collections.unmodifiableList(books);
	}

	/**
	 * ---------------------- SORTING ALGOS ----------------------
	 */

	/**
	 * The Comparator to sort books by title.
	 * 
	 * @author Rohtash Singh Lakra
	 * @date 10/18/2016 02:58:18 PM
	 *
	 */
	public static class SortByTitle implements Comparator<Book> {

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Book book, Book other) {
			if (book == null) {
				return -1;
			} else if (other == null) {
				return 1;
			} else {
				return book.getTitle().compareTo(other.getTitle());
			}
		}
	}

	/**
	 * 
	 * @author Rohtash Singh Lakra
	 * @date 10/18/2016 02:58:14 PM
	 *
	 */
	public static class SortByGenre implements Comparator<Book> {

		/**
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(Book book, Book other) {
			if (book == null) {
				return -1;
			} else if (other == null) {
				return 1;
			} else {
				return book.getGenre().compareTo(other.getGenre());
			}
		}

	}

	/**
	 * float CheckIn (book)
	 * 
	 * Effect: Accesses book and checks it into this library. Returns a fine
	 * amount (0 if there is no fine).
	 * 
	 * Preconditions: Book was checked out of this library; book is presented at
	 * the check-in desk.
	 * 
	 * Postconditions: return value = (amount of fine due); contents of this
	 * library is the original contents + book
	 * 
	 * Exception: This library is not open
	 * 
	 * @param book
	 * @return
	 */
	public static float checkInBook(Book book) {
		return 0.0F;
	}

}
