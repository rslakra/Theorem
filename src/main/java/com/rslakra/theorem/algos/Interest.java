package com.rslakra.theorem.algos;

/**
 * @author Rohtash Lakra
 * @version 1.0.0
 * @created Nov 07, 2020 19:11:38
 * @since 1.0.0
 */
public class Interest {


    /**
     * Compute the compound interest.
     *
     * @param principle
     * @param rate
     * @param timeInMonths
     * @return
     */
    public double compoundYearly(double principle, double rate, double timeInMonths) {
        return (principle * Math.pow((1 + ((rate / 100.0) / 12)), timeInMonths));
    }

    /**
     * @param principle
     * @param rate
     * @param year
     * @param times
     * @return
     */
    public double compoundMonthly(double principle, double rate, double year, double times) {
        return (principle * Math.pow((1 + ((rate / 100.0) / 12)), year * times));
    }

    /**
     * @param principle
     * @param rate
     * @param timeInMonths
     * @return
     */
    public double simple(double principle, double rate, double timeInMonths) {
        return (principle * (rate / 100.0) * timeInMonths / 12);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        int p = 1000;
        int r = 6;
        int t = 3;
        Interest interest = new Interest();
        System.out.printf("%.2f", interest.simple(p, r, t));
        System.out.println();
        System.out.printf("%.2f", interest.compoundMonthly(p, r, 1, 3));
        System.out.println();
        System.out.printf("%.2f", interest.compoundYearly(p, r, t));
        System.out.println();
    }
}
