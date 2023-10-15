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
package com.rslakra.datastructure.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * Handles the secure password encryption.
 * 
 * 
 * Hash passwords for storage, and test passwords against password tokens.
 * 
 * @author Rohtash Singh Lakra
 * @date 09/15/2016 01:27:44 PM
 */
public final class SecurityHelper {
	
	/**
	 * Each and every token must use this identifier as a prefix.
	 */
	public static final String ID = "16";
	
	/**
	 * The minimum recommended cost, used by default
	 */
	public static final int DEFAULT_COST = 16;
	
	private static final String ALGORITHM = "PBKDF2WithHmacSHA1";
	
	private static final int SIZE = 128;
	
	private static final Pattern layout = Pattern.compile("\\$31\\$(\\d\\d?)\\$(.{43})");
	
	private final SecureRandom secureRandom;
	
	private final int cost;
	
	public SecurityHelper() {
		this(DEFAULT_COST);
	}
	
	/**
	 * Create a password manager with a specified cost
	 * 
	 * @param cost the exponential computational cost of hashing a password, 0
	 *            to 30
	 */
	public SecurityHelper(int cost) {
		iterations(cost); /* Validate cost */
		this.cost = cost;
		this.secureRandom = new SecureRandom();
	}
	
	/**
	 * 
	 * @param cost
	 * @return
	 */
	private static int iterations(int cost) {
		if((cost & ~0x1F) != 0) {
			throw new IllegalArgumentException("cost: " + cost);
		}
		
		return (1 << cost);
	}
	
	/**
	 * Hash a password for storage.
	 * 
	 * @return a secure authentication token to be stored for later
	 *         authentication
	 */
	public String hash(char[] password) {
		byte[] salt = new byte[SIZE / 8];
		secureRandom.nextBytes(salt);
		byte[] derivedKey = pbkdf2(password, salt, 1 << cost);
		byte[] hash = new byte[salt.length + derivedKey.length];
		System.arraycopy(salt, 0, hash, 0, salt.length);
		System.arraycopy(derivedKey, 0, hash, salt.length, derivedKey.length);
		Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
		return (ID + cost + '$' + encoder.encodeToString(hash));
	}
	
	/**
	 * Authenticate with a password and a stored password token.
	 * 
	 * @return true if the password and token match
	 */
	public boolean authenticate(char[] password, String token) {
		Matcher matcher = layout.matcher(token);
		if(!matcher.matches()) {
			throw new IllegalArgumentException("Invalid token format");
		}
		
		int iterations = iterations(Integer.parseInt(matcher.group(1)));
		byte[] hash = Base64.getUrlDecoder().decode(matcher.group(2));
		byte[] salt = Arrays.copyOfRange(hash, 0, SIZE / 8);
		byte[] check = pbkdf2(password, salt, iterations);
		int zero = 0;
		for(int idx = 0; idx < check.length; ++idx) {
			zero |= hash[salt.length + idx] ^ check[idx];
		}
		
		return (zero == 0);
	}
	
	private static byte[] pbkdf2(char[] password, byte[] salt, int iterations) {
		KeySpec keySpec = new PBEKeySpec(password, salt, iterations, SIZE);
		try {
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
			return keyFactory.generateSecret(keySpec).getEncoded();
		} catch(NoSuchAlgorithmException ex) {
			throw new IllegalStateException("Missing algorithm:" + ALGORITHM, ex);
		} catch(InvalidKeySpecException ex) {
			throw new IllegalStateException("Invalid SecretKeyFactory", ex);
		}
	}
	
	/**
	 * Hash a password in an immutable {@code String}.
	 * 
	 * <p>
	 * Passwords should be stored in a {@code char[]} so that it can be filled
	 * with zeros after use instead of lingering on the heap and elsewhere.
	 * 
	 * @deprecated Use {@link #hash(char[])} instead
	 */
	public String hash(String password) {
		return hash(password.toCharArray());
	}
	
	/**
	 * Authenticate with a password in an immutable {@code String} and a stored
	 * password token.
	 * 
	 * @deprecated Use {@link #authenticate(char[],String)} instead.
	 * @see #hash(String)
	 */
	public boolean authenticate(String password, String token) {
		return authenticate(password.toCharArray(), token);
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
	}
	
}
