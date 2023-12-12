package com.devamatre.theorem.domain.entity.business;

/**
 * @author Rohtash Lakra
 * @created 12/8/23 1:02 PM
 */
public enum JobStatus {

    APPLIED("Applied", "Applied or Received OR Application Submitted"),
    FUTURE_CONSIDERATION("For Future Consideration", "For Future Consideration"),
    HIRED("Hired", "Hired"),
    INCOMPLETE_APPLICATION("Incomplete application", "Incomplete application"),
    IN_PROGRESS("In Progress", "In Progress"),
    INTERVIEWED("Interviewed", "Interviewed"),
    INTERVIEWING("Interviewing", "Interviewing"),
    NO_LONGER_IN_CONSIDERATION("No Longer in Consideration", "No Longer in Consideration"),
    OFFER("Offer", "Offer"),
    OFFER_ACCEPTED("Offer Accepted", "Offer Accepted"),
    OFFER_DECLINED("Offer Declined", "Offer Declined"),
    POSITION_CLOSED("Position closed", "Position closed"),
    POSITION_FILLED("Position Filled", "Position Filled"),
    POSITION_WITHDRAWN("Position Withdrawn", "Position Withdrawn"),
    SHORTLISTED("Shortlisted", "Shortlisted"),
    REJECTED("Rejected", "Rejected"),
    UNDER_REVIEW("Under Review", "Under Review"),
    UNDER_CONSIDERATION("Under Consideration", "Under Consideration"),
    ;

    private String status;
    private String description;

    /**
     * @param status
     * @param description
     */
    JobStatus(String status, String description) {
        this.status = status;
        this.description = description;
    }
}
