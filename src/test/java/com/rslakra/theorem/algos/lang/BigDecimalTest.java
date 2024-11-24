package com.rslakra.theorem.algos.lang;

import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rohtash Lakra
 * @created 1/4/24 12:23 PM
 */
public class BigDecimalTest {

    private Iterator<Object[]> inputData() {
        List<Object[]> input = new ArrayList<>();
        // refund amount, last transaction tax amount, total refund
        input.add(new Object[]{new BigDecimal(479.23), new BigDecimal(479.23), new BigDecimal(480)});
        input.add(new Object[]{new BigDecimal(485.02), new BigDecimal(497)});
        input.add(new Object[]{new BigDecimal(628.47), new BigDecimal(655)});
        input.add(new Object[]{new BigDecimal(350), new BigDecimal(368)});
        input.add(new Object[]{new BigDecimal(120.56), new BigDecimal(121)});

        return input.iterator();
    }

    @Test(dataProvider = "inputData")
    public void testPercentage(BigDecimal refundAmount, BigDecimal lastTax, BigDecimal expected) {
        BigDecimal
            refundTax =
            refundAmount.divide(refundAmount.abs(), 20, BigDecimal.ROUND_HALF_UP).multiply(lastTax.abs());
        //return a tax amount that could make full amount has no decimal points for TW advertisers
        BigDecimal fullAmount = refundAmount.add(refundTax).setScale(0, BigDecimal.ROUND_HALF_UP);
        refundTax = fullAmount.subtract(refundAmount);
    }
}
