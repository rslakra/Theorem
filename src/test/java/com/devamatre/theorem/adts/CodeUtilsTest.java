package com.devamatre.theorem.adts;

import org.testng.annotations.Test;

/**
 * @author Rohtash Lakra
 * @created 10/11/23 3:23 PM
 */
public class CodeUtilsTest {

    /**
     *
     */
    @Test
    public void testConvertLeetCode2DStringArrayInputIntoJavaArray() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        AlgoUtils.printArray(nums);

        String
            input1 =
            "[\"zDkA\",\"GfAj\",\"lt\"],[\"GfAj\",\"rtupD\",\"og\",\"l\"],[\"rtupD\",\"IT\",\"jGcew\",\"ZwFqF\"],[\"og\",\"yVobt\",\"EjA\",\"piUyQ\"],[\"IT\",\"XFlc\",\"W\",\"rB\"],[\"l\",\"GwQg\",\"shco\",\"Dub\",\"KwgZq\"],[\"oXMG\",\"uqe\"],[\"sNyV\",\"WbrP\"]";
        String input2 = "[\"A\",\"B\"],[\"C\"],[\"B\",\"C\"],[\"D\"]";
        AlgoUtils.print2DList(CodeUtils.convertLeetCode2DStringArrayInputIntoJavaArray(input1));
        AlgoUtils.print2DList(CodeUtils.convertLeetCode2DStringArrayInputIntoJavaArray(input2));
        AlgoUtils.print(CodeUtils.convertLeetCode1DStringArrayInputIntoJavaArray(
            "[\"abcsi\",\"abyzjgj\",\"advz\",\"ag\",\"agkgdkob\",\"agpr\",\"ail\"]"));
        AlgoUtils.print2DArray(CodeUtils.convertLeetCodeIrregularLengths2DArrayInputIntoJavaArray(
            "[448,931,123,345],[889],[214,962],[576,746,897]"));
    }
}
