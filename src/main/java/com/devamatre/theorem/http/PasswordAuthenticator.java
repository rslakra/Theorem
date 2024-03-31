package com.devamatre.theorem.http;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * @author Rohtash Lakra
 * @created 2/28/24 5:57 PM
 */
public class PasswordAuthenticator extends Authenticator {

    private String userName;
    private char[] password;

    /**
     * @param userName
     * @param password
     */
    public PasswordAuthenticator(String userName, char[] password) {
        super();
        this.userName = userName;
        this.password = password;
    }

    /**
     * @param userName
     * @param password
     */
    public PasswordAuthenticator(String userName, String password) {
        this(userName, password.toCharArray());
    }

    /**
     * @return
     */
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}
