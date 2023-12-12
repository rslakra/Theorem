package com.devamatre.theorem.adts.queue;

import lombok.Getter;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created 2018-01-06 03:32:51 PM
 * @since 1.0.0
 */
@Getter
public class TrainCoach implements Comparable<TrainCoach> {

    private Long id;
    private String coachType;

    /**
     * @param id
     * @param coachType
     */
    public TrainCoach(Long id, String coachType) {
        this.id = id;
        this.coachType = coachType;
    }

    /**
     * @param trainCoach
     * @return
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    @Override
    public int compareTo(TrainCoach trainCoach) {
        int result = -1;
        if (trainCoach != null) {
            result = getId().compareTo(trainCoach.getId());
            if (result == 0) {
                return getCoachType().compareTo(trainCoach.getCoachType());
            }
        }

        return result;
    }

}
