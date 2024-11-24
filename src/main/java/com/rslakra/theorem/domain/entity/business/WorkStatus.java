package com.rslakra.theorem.domain.entity.business;

/**
 * In general, US organizations use employment status to refer to the type of implied or written contract between the
 * employer and employee.
 * <p>
 * Depending on the nature of the work, an individual can have several employment statuses at the same time:
 *
 * <pre>
 * Employers determine the employment status of newly hired personnel. Other employment status classifications exist in the U.S. and are applied depending on the context. For example, full-time employees may be further divided into exempt and non-exempt status to determine their overtime pay eligibility.
 * </pre>
 *
 * @author Rohtash Lakra
 * @created 12/8/23 12:46 PM
 */
public enum WorkStatus {

    /* Employment Status in the United States */
    CONTRACTOR(Country.USA, "Contract Employee",
               "Employed for a predefined period to provide work according to contract terms"),
    FULL_TIME(Country.USA, "Full-Time Employee", "Employed for 40 hours or more per week with salary and benefits"),
    INDEPENDENT(Country.USA, "Independent Contractor", "Non-employee providing labor according to contract terms"),
    INTERN(Country.USA, "Intern or Apprentice", "Temporary employee providing labor for educational benefit"),
    PART_TIME(Country.USA, "Part-Time Employee", "Employed at hourly wage for fewer than 40 hours per week"),
    SELF_EMPLOYED(Country.USA, "Self-Employed", "The employer and employee are the same person"),
    TEMPORARY(Country.USA, "Temporary or Seasonal Employee", "The employer and employee are the same person"),
    UNEMPLOYED(Country.USA, "Unemployed", "Former employee no longer providing work for the employer"),
    VOLUNTEER(Country.USA, "Volunteer", "Non-employee voluntarily providing labor with no expectation of payment"),
    ;

    private Country country;
    private String status;
    private String description;

    /**
     * @param country
     * @param status
     * @param description
     */
    WorkStatus(Country country, String status, String description) {
        this.country = country;
        this.status = status;
        this.description = description;
    }
}
