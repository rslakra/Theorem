package com.rslakra.core.security;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * This class implements the PBKDF2 in pure java.
 * 
 * https://www.ietf.org/rfc/rfc2898.txt
 * 
 * @author Rohtash Singh Lakra
 * @date 11/21/2016 12:10:03 PM
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
	
	private PBKDF2Params pbkdf2Params;
	
	/**
	 * 
	 * @param pbkdf2Params
	 */
	public PBKDF2Generator(PBKDF2Params pbkdf2Params) {
		this.pbkdf2Params = pbkdf2Params;
	}
	
	/**
	 * 
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static byte[] getSalt(String algorithm) throws NoSuchAlgorithmException {
		SecureRandom secureRandom = SecureRandom.getInstance(algorithm);
		byte[] salt = new byte[16];
		secureRandom.nextBytes(salt);
		return salt;
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
		String hexString = bigInteger.toString(16);
		int paddingLength = (dataBytes.length * 2) - hexString.length();
		if(paddingLength > 0) {
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
		for(int i = 0; i < hexBytes.length; i++) {
			hexBytes[i] = (byte) Integer.parseInt(hexString.substring(2 * i, 2 * i + 2), 16);
		}
		
		return hexBytes;
	}
	
	/**
	 * 
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
		} catch(InvalidKeySpecException ex) {
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
		return toHex(getPBKDF2Bytes(password, keyLength));
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
		String pbkdf2String = null;
		byte[] hashBytes = getPBKDF2Bytes(password, keyLength);
		pbkdf2String = (pbkdf2Params.getIterations() + ":" + toHex(pbkdf2Params.getSalt()) + ":" + toHex(hashBytes));
		
		return pbkdf2String;
	}
	
	/**
	 * Validates the password with the hashed password.
	 * 
	 * @param originalPassword
	 * @param hashedPassword
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeySpecException
	 */
	public boolean validatePassword(String password, String hashedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException {
		String[] parts = hashedPassword.split(":");
		int iterations = Integer.parseInt(parts[0]);
		byte[] salt = fromHex(parts[1]);
		byte[] hash = fromHex(parts[2]);
		byte[] pbkdf2Hash = pbkdf2(password.toCharArray(), salt, iterations, hash.length);
		
		int difference = hash.length ^ pbkdf2Hash.length;
		for(int i = 0; i < hash.length && i < pbkdf2Hash.length; i++) {
			difference |= hash[i] ^ pbkdf2Hash[i];
		}
		
		return (difference == 0);
	}
	
	/**
	 * The parameters of the PBKDF2 parameters.
	 * 
	 * @author Rohtash Singh Lakra
	 * @date 11/21/2016 03:32:24 PM
	 */
	static final class PBKDF2Params {
		private String algorithm;
		private String charset;
		private byte[] salt;
		private int iterations;
		
		/**
		 * 
		 * @param algorithm
		 * @param charset
		 * @param salt
		 * @param iterations
		 */
		public PBKDF2Params(final String algorithm, final String charset, final byte[] salt, final int iterations) {
			this.algorithm = algorithm;
			this.charset = charset;
			this.salt = salt;
			this.iterations = iterations;
		}
		
		/**
		 * Returns the algorithm.
		 * 
		 * @return
		 */
		public String getAlgorithm() {
			return algorithm;
		}
		
		/**
		 * Returns the charset.
		 * 
		 * @return
		 */
		public String getCharset() {
			return charset;
		}
		
		/**
		 * Returns the salt.
		 * 
		 * @return
		 */
		public byte[] getSalt() {
			return salt;
		}
		
		/**
		 * Returns the iterations.
		 * 
		 * @return
		 */
		public int getIterations() {
			return iterations;
		}
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
		byte[] salt = PBKDF2Generator.getSalt(PBKDF2Generator.SHA1PRNG);
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