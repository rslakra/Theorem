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
package com.rslakra.datastructure.utils;

/**
 * 
 * @author Rohtash Singh Lakra
 * @date 10/18/2016 02:15:00 PM
 */
public final class Objects {
	/**
	 * Returns true if the object is null or otherwise false.
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isNull(Object object) {
		return (null == object);
	}

	/**
	 * Returns true if the object is not null otherwise false.
	 * 
	 * @param object
	 * @return
	 */
	public static boolean isNotNull(Object object) {
		return (!isNull(object));
	}

	/**
	 * Returns true if either the strings array is null or empty otherwise
	 * false.
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean isNullOrEmpty(Object... objects) {
		return (isNull(objects) || objects.length == 0);
	}

	/**
	 * Returns the string representation of the specified <code>object</code>;
	 * 
	 * @param object
	 * @param useReflection
	 * @return
	 */
	public static String toString(Object object, boolean useReflection) {
		return (useReflection ? new ToString().toString(object) : object.toString());
	}

	/**
	 * 
	 * @param object
	 * @return
	 */
	public static String toString(Object object) {
		return toString(object, true);
	}
}
