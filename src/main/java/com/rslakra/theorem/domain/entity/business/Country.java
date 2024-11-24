package com.rslakra.theorem.domain.entity.business;

/**
 * @author Rohtash Lakra
 * @created 12/8/23 12:52 PM
 */
public enum Country {

    INDIA("India"),
    USA("United States");

    private String country;

    /**
     * @param country
     */
    Country(String country) {
        this.country = country;
    }

}
