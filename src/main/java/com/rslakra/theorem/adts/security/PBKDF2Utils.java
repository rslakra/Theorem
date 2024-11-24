/*******************************************************************************
 * Copyright (C) Devamatre Inc. 2009-2018. All rights reserved.
 *
 * This code is licensed to Devamatre under one or more contributor license
 * agreements. The reproduction, transmission or use of this code or the snippet
 * is not permitted without prior express written consent of Devamatre.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the license is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied and the
 * offenders will be liable for any damages. All rights, including but not
 * limited to rights created by patent grant or registration of a utility model
 * or design, are reserved. Technical specifications and features are binding
 * only insofar as they are specifically and expressly agreed upon in a written
 * contract.
 *
 * You may obtain a copy of the License for more details at:
 * http://www.devamatre.com/licenses/license.txt.
 *
 * Devamatre reserves the right to modify the technical specifications and or
 * features without any prior notice.
 *******************************************************************************/
package com.rslakra.theorem.adts.security;

import com.rslakra.theorem.adts.security.pbkdf2.PBKDF2Params;

import java.math.BigInteger;
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
 * <p>
 * <p>
 * Hash passwords for storage, and test passwords against password tokens.
 *
 * @author Rohtash Lakra
 * @created 09/15/2016 01:27:44 PM
 */
public enum PBKDF2Utils {

    INSTANCE;

    /**
     * The minimum recommended cost, used by default Each and every token must use this identifier as a prefix.
     */
    public static final String UTF_8 = "UTF-8";
    /* Radix */
    public static final int RADIX = 16;
    /* Salt Size */
    public static final int SALT_SIZE = 16;
    /* Iterations */
    public static final int ITERATIONS = 10000;
    /* Key Length */
    public static final int KEY_LENGTH = 16;
    public static final String ALGORITHM = "PBKDF2WithHmacSHA1";
    /* Size */
    public static final int SIZE = 128;
    public static final Pattern TOKEN_PATTERN = Pattern.compile("\\$31\\$(\\d\\d?)\\$(.{43})");

    private final SecureRandom secureRandom = new SecureRandom();

    /**
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static byte[] getSalt(String algorithm) throws NoSuchAlgorithmException {
        byte[] salt = new byte[SALT_SIZE];
        SecureRandom.getInstance(algorithm).nextBytes(salt);
        return salt;
    }

    /**
     * Returns the byte value of an int value.
     *
     * @param hexString
     * @param radix
     * @return
     */
    public static byte toByte(String hexString, int radix) {
        return (byte) Integer.parseInt(hexString, radix);
    }

    /**
     * Returns the hex-string for the specified <code>dataBytes</code> bytes.
     *
     * @param dataBytes
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String toHex(byte[] dataBytes) throws NoSuchAlgorithmException {
        BigInteger bigInteger = new BigInteger(1, dataBytes);
        String hexString = bigInteger.toString(RADIX);
        int paddingLength = (dataBytes.length * 2) - hexString.length();
        if (paddingLength > 0) {
            hexString = String.format("%0" + paddingLength + "d", 0) + hexString;
        }

        return hexString;
    }

    /**
     * Returns the bytes for the specified hex-string <code>hexString</code>.
     *
     * @param hexString
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static byte[] fromHex(String hexString) throws NoSuchAlgorithmException {
        byte[] hexBytes = new byte[hexString.length() / 2];
        for (int i = 0; i < hexBytes.length; i++) {
            hexBytes[i] = toByte(hexString.substring(2 * i, 2 * i + 2), RADIX);
        }

        return hexBytes;
    }

    /**
     * @param cost
     * @return
     */
    private int iterations(int cost) {
        if ((cost & ~0x1F) != 0) {
            throw new IllegalArgumentException("cost: " + cost);
        }

        return (1 << cost);
    }

    /**
     * Returns the new <code>PBKDF2Params</code> object.
     *
     * @param algorithm
     * @param charset
     * @param salt
     * @param iterations
     * @return
     */
    public static PBKDF2Params newPBKDF2Params(String algorithm, String charset, byte[] salt, int iterations) {
        return new PBKDF2Params(algorithm, charset, salt, iterations);
    }

    /**
     * Returns the new <code>PBKDF2Params</code> object.
     *
     * @param algorithm
     * @param salt
     * @return
     */
    public static PBKDF2Params newPBKDF2Params(String algorithm, byte[] salt) {
        return newPBKDF2Params(algorithm, UTF_8, salt, ITERATIONS);
    }

    /**
     * @param password
     * @param salt
     * @param iterations
     * @return
     */
    private static byte[] pbkdf2(char[] password, byte[] salt, int iterations) {
        KeySpec keySpec = new PBEKeySpec(password, salt, iterations, SIZE);
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(ALGORITHM);
            return keyFactory.generateSecret(keySpec).getEncoded();
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("Missing algorithm:" + ALGORITHM, ex);
        } catch (InvalidKeySpecException ex) {
            throw new IllegalStateException("Invalid SecretKeyFactory", ex);
        }
    }

    /**
     * Hash a password for storage.
     *
     * @return a secure authentication token to be stored for later authentication
     */
    public String hash(char[] password) {
        byte[] salt = new byte[SALT_SIZE];
        secureRandom.nextBytes(salt);
        byte[] derivedKey = pbkdf2(password, salt, 1 << SALT_SIZE);
        byte[] hash = new byte[salt.length + derivedKey.length];
        System.arraycopy(salt, 0, hash, 0, salt.length);
        System.arraycopy(derivedKey, 0, hash, salt.length, derivedKey.length);
        Base64.Encoder encoder = Base64.getUrlEncoder().withoutPadding();
        return String.format("%d%d$%s", SALT_SIZE, SALT_SIZE, encoder.encodeToString(hash));
    }

    /**
     * Hash a password in an immutable {@code String}.
     *
     * <p>
     * Passwords should be stored in a {@code char[]} so that it can be filled with zeros after use instead of lingering
     * on the heap and elsewhere.
     *
     * @deprecated Use {@link #hash(char[])} instead
     */
    public String hash(String password) {
        return hash(password.toCharArray());
    }

    /**
     * Authenticate with a password and a stored password token.
     *
     * @return true if the password and token match
     */
    public boolean authenticate(char[] password, String token) {
        Matcher matcher = TOKEN_PATTERN.matcher(token);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid token format");
        }

        int iterations = INSTANCE.iterations(Integer.parseInt(matcher.group(1)));
        byte[] hash = Base64.getUrlDecoder().decode(matcher.group(2));
        byte[] salt = Arrays.copyOfRange(hash, 0, SIZE / 8);
        byte[] check = pbkdf2(password, salt, iterations);
        int zero = 0;
        for (int idx = 0; idx < check.length; ++idx) {
            zero |= hash[salt.length + idx] ^ check[idx];
        }

        return (zero == 0);
    }

    /**
     * Authenticate with a password in an immutable {@code String} and a stored password token.
     *
     * @param password
     * @param token
     * @return
     */
    public boolean authenticate(String password, String token) {
        return authenticate(password.toCharArray(), token);
    }

}
