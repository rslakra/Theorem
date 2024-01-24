package com.devamatre.theorem.hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Rohtash Singh Lakra
 * @created 09/21/2017 02:32:21 PM
 */
public class Database {

    private String userName;
    private String password;
    private int age;
    private Set<Integer> idOrders;

    /**
     * @param userName
     * @param password
     * @param age
     * @param idOrders
     */
    public Database(String userName, String password, int age, Set<Integer> idOrders) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.idOrders = idOrders;
    }

    /**
     * Returns the string representation of this object.
     */
    public String toString() {
        return (new StringBuilder().append("[").append(userName).append(", ").append(password).append(", ").append(age)
                    .append(", ").append(idOrders).append("]").toString());
    }

    public static void main(String[] args) {

        Set<Integer> idOrders = new HashSet<Integer>();
        idOrders.add(1616);
        Database user = new Database("Rohtash", "Hello", 40, idOrders);
        System.out.println(user);
    }

}
