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
package com.rslakra.theorem.adts.security.pbkdf2;

import com.rslakra.theorem.adts.security.PBKDF2Utils;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * This class implements the PBKDF2 in pure java.
 * <p>
 * https://www.ietf.org/rfc/rfc2898.txt
 *
 * @author Rohtash Lakra
 * @created 11/21/2016 12:10:03 PM
 */
public final class PBKDF2Generator {

    /* The secret keys algorithm */
    public static final String PBKDF2_WITH_HMAC_SHA512 = "PBKDF2WithHmacSHA512";
    /* Secure Random Algorithm */
    public static final String SHA1PRNG = "SHA1PRNG";
    /* Iterations */
    public static final int ITERATIONS = 10000;
    /* Key Length */
    public static final int KEY_LENGTH = 16;

    private final PBKDF2Params pbkdf2Params;

    /**
     * @param pbkdf2Params
     */
    public PBKDF2Generator(PBKDF2Params pbkdf2Params) {
        this.pbkdf2Params = pbkdf2Params;
    }

    /**
     * @param password
     * @param salt
     * @param iterations
     * @param keyLength
     * @return
     * @throws NoSuchAlgorithmException
     */
    private byte[] pbkdf2(char[] password, byte[] salt, int iterations, int keyLength) throws NoSuchAlgorithmException {
        try {
            PBEKeySpec keySpec = new PBEKeySpec(password, salt, iterations, keyLength * 8);
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(pbkdf2Params.getAlgorithm());
            return keyFactory.generateSecret(keySpec).getEncoded();
        } catch (InvalidKeySpecException ex) {
            throw new IllegalStateException("Invalid SecretKeyFactory", ex);
        }
    }

    /**
     * Returns the PBKDF2 bytes of the given password.
     *
     * @param password
     * @param keyLength
     * @return
     * @throws NoSuchAlgorithmException
     */
    public byte[] getPBKDF2Bytes(String password, int keyLength) throws NoSuchAlgorithmException {
        return pbkdf2(password.toCharArray(), pbkdf2Params.getSalt(), pbkdf2Params.getIterations(), keyLength);
    }

    /**
     * Returns the PBKDF2 hex string of the given password.
     *
     * @param password
     * @param keyLength
     * @return
     * @throws NoSuchAlgorithmException
     */
    public String pbkdf2HexString(String password, int keyLength) throws NoSuchAlgorithmException {
        return PBKDF2Utils.toHex(getPBKDF2Bytes(password, keyLength));
    }

    /**
     * Returns the PBKDF2 bytes of the given password.
     *
     * @param password
     * @param keyLength
     * @return
     * @throws NoSuchAlgorithmException
     */
    public String hashPassword(String password, int keyLength) throws NoSuchAlgorithmException {
        byte[] hashBytes = getPBKDF2Bytes(password, keyLength);
        String
            pbkdf2String =
            String.format("%d:%s:%s", pbkdf2Params.getIterations(), PBKDF2Utils.toHex(pbkdf2Params.getSalt()),
                          PBKDF2Utils.toHex(hashBytes));
        return pbkdf2String;
    }

    /**
     * Validates the password with the hashed password.
     *
     * @param password
     * @param hashedPassword
     * @return
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public boolean validatePassword(String password, String hashedPassword)
        throws NoSuchAlgorithmException, InvalidKeySpecException {
        String[] parts = hashedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = PBKDF2Utils.fromHex(parts[1]);
        byte[] hash = PBKDF2Utils.fromHex(parts[2]);
        byte[] pbkdf2Hash = pbkdf2(password.toCharArray(), salt, iterations, hash.length);

        int difference = hash.length ^ pbkdf2Hash.length;
        for (int i = 0; i < hash.length && i < pbkdf2Hash.length; i++) {
            difference |= hash[i] ^ pbkdf2Hash[i];
        }

        return (difference == 0);
    }

    /**
     * authenticate
     *
     * @param args
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeySpecException
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
        String password = "password";
        byte[] salt = PBKDF2Utils.getSalt(PBKDF2Generator.SHA1PRNG);
        PBKDF2Params pbkdf2Params = new PBKDF2Params(PBKDF2_WITH_HMAC_SHA512, "UTF-8", salt, ITERATIONS);
        PBKDF2Generator pbkdf2Generator = new PBKDF2Generator(pbkdf2Params);
        String pbkdf2String = pbkdf2Generator.hashPassword(password, KEY_LENGTH);
        System.out.println(pbkdf2String);

        boolean matched = pbkdf2Generator.validatePassword(password, pbkdf2String);
        System.out.println(matched);

        matched = pbkdf2Generator.validatePassword("password1", pbkdf2String);
        System.out.println(matched);
    }
}
