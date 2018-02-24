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
 * @author Rohtash Singh Lakra
 * @date 09/08/2016 04:38:08 PM
 *
 */
public final class Strings {
	/** UTF-8 */
	public static final String UTF_8 = "UTF-8";
	/** ISO-8859-1 */
	public static final String ISO_8859_1 = "ISO-8859-1";
	/** HEXA_DIGITS */
	public static final String HEXA_DIGITS = "0123456789ABCDEF";

	private Strings() {

	}

	/**
	 * Returns true if either the string is null or empty otherwise false.
	 * 
	 * @param string
	 * @return
	 */
	public static boolean isNullOrEmpty(String string) {
		return (Objects.isNull(string) || string.isEmpty());
	}

	/**
	 * Returns the string representation of the specified <code>bytes</code>
	 * with the specified <code>charsetName</code> String.
	 * 
	 * @param bytes
	 * @param charsetName
	 * @return
	 */
	public static String toString(byte[] bytes, String charsetName) {
		String bytesAsString = null;
		if (!Objects.isNullOrEmpty(bytes)) {
			try {
				if (isNullOrEmpty(charsetName)) {
					bytesAsString = new String(bytes);
				} else {
					bytesAsString = new String(bytes, charsetName);
				}
			} catch (Exception ex) {
				bytesAsString = (Objects.isNull(bytes) ? null : bytes.toString());
			}
		}

		return bytesAsString;
	}

	/**
	 * Returns the string representation of the specified <code>bytes</code>;
	 * 
	 * @param bytes
	 * @return
	 */
	public static String toString(byte[] bytes) {
		return toString(bytes, null);
	}

	/**
	 * Returns the UTF-8 String representation of the given <code>bytes</code>.
	 * 
	 * @param bytes
	 * @return
	 */
	public static String toUTF8String(byte[] bytes) {
		return toString(bytes, UTF_8);
	}

	/**
	 * Returns the ISO_8859_1 String representation of the given
	 * <code>bytes</code>.
	 * 
	 * @param bytes
	 * @return
	 */
	public static String toISOString(byte[] bytes) {
		return toString(bytes, ISO_8859_1);
	}

	/**
	 * Converts the specified <code>string</code> into bytes using the specified
	 * <code>charsetName</code>.
	 * 
	 * @param string
	 * @param charsetName
	 * @return
	 */
	public static byte[] toBytes(String string, String charsetName) {
		byte[] stringAsBytes = null;
		if (!Objects.isNull(string)) {
			try {
				stringAsBytes = isNullOrEmpty(charsetName) ? string.getBytes() : string.getBytes(charsetName);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return stringAsBytes;
	}

	/**
	 * Converts the specified <code>string</code> into bytes.
	 * 
	 * @param string
	 * @return
	 */
	public static byte[] toBytes(String string) {
		return toBytes(string, null);
	}

	/**
	 * Returns the UTF-8 bytes of the given <code>string</code>.
	 * 
	 * @param bytes
	 * @return
	 */
	public static byte[] toUTF8Bytes(String string) {
		return toBytes(string, UTF_8);
	}

	/**
	 * Returns the ISO_8859_1 bytes of the given <code>string</code>.
	 * 
	 * @param bytes
	 * @return
	 */
	public static byte[] toISOBytes(String string) {
		return toBytes(string, ISO_8859_1);
	}

	/**
	 * Converts the bytes to hexadecimal string.
	 * 
	 * @param bytes
	 * @return
	 */
	public static String toHexString(final byte[] bytes) {
		String hexString = null;
		if (!Objects.isNullOrEmpty(bytes)) {
			StringBuilder hexaBuilder = new StringBuilder(bytes.length * 2);
			for (int index = 0; index < bytes.length; index++) {
				int highNumber = ((int) (bytes[index]) & 0x00ff) / 16;
				int lowNumber = ((int) (bytes[index]) & 0x000f);
				hexaBuilder.append(HEXA_DIGITS.charAt(highNumber));
				hexaBuilder.append(HEXA_DIGITS.charAt(lowNumber));
			}

			hexString = hexaBuilder.toString();
			// available for GC.
			hexaBuilder = null;
		}

		return hexString;
	}

	/**
	 * Convert hex digit to numerical value.
	 * 
	 * @param hexDigit
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static int toNumeric(char hexDigit) {
		if (hexDigit >= '0' && hexDigit <= '9') {
			return (hexDigit - '0');
		} else if (hexDigit >= 'A' && hexDigit <= 'F') {
			return (hexDigit - 'A' + 10);
		} else if (hexDigit >= 'a' && hexDigit <= 'f') {
			return (hexDigit - 'a' + 10);
		} else {
			throw new IllegalArgumentException("Invalid digit (should only contain hex digits)!, found'" + hexDigit + "'");
		}
	}

	/**
	 * Convert hex string to array of bytes.
	 * 
	 * @param hexString
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static byte[] toHexBytes(String hexString) {
		if (Objects.isNull(hexString)) {
			// Allow empty input string.
			hexString = "";
		} else if (hexString.length() % 2 != 0) {
			// Assume leading zero for odd string length
			hexString = "0" + hexString;
		}

		byte[] hexBytes = new byte[hexString.length() / 2];
		for (int i = 0, j = 0; i < hexString.length(); j++) {
			hexBytes[j] = (byte) (toNumeric(hexString.charAt(i++)) * 16 + toNumeric(hexString.charAt(i++)));
		}

		return hexBytes;
	}

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		byte bytes[] = new byte[256];
		byte bb = 0;
		for (int i = 0; i < 256; i++) {
			bytes[i] = bb++;
		}

		String hexString = toHexString(bytes);
		System.out.println("hexString:" + hexString);
		byte hexBytes[] = toHexBytes(hexString);
		String newHexString = toHexString(hexBytes);
		System.out.println("newHexString:" + newHexString);
		if (hexString.equals(newHexString)) {
			System.out.println("Matched!");
		} else {
			throw new AssertionError("Mismatch!");
		}
	}
}
