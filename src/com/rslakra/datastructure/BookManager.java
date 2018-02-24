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
package com.rslakra.datastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.rslakra.datastructure.bos.Book;
import com.rslakra.datastructure.utils.Objects;

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
