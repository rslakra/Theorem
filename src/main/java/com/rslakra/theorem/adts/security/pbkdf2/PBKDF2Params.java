package com.rslakra.theorem.adts.security.pbkdf2;

/**
 * The parameters of the PBKDF2 parameters.
 *
 * @author Rohtash Lakra
 * @created 11/21/2016 03:32:24 PM
 */
public class PBKDF2Params {

    private final String algorithm;
    private final String charset;
    private final byte[] salt;
    private final int iterations;

    /**
     * @param algorithm
     * @param charset
     * @param salt
     * @param iterations
     */
    public PBKDF2Params(String algorithm, String charset, byte[] salt, int iterations) {
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
