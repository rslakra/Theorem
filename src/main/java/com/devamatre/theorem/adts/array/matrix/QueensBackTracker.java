package com.devamatre.theorem.adts.array.matrix;

import com.devamatre.theorem.adts.array.BackTracker;

/**
 * @author Rohtash Lakra
 * @created 2/28/24 3:32 PM
 */
public class QueensBackTracker extends BackTracker {

    /**
     * Subclass-specific method that returns whether the partial solution in slots 0..position-1 is okay so far.
     *
     * @param solution
     * @param position
     * @return
     */
    @Override
    protected boolean safeUpTo(int[] solution, int position) {
        int thisColumn = position;
        int thisRow = solution[position];
        for (int column = thisColumn - 1; column >= 0; column--) {
            if (solution[column] == thisRow ||
                solution[column] == thisRow + thisColumn - column ||
                solution[column] == thisRow + column - thisColumn) {
                return false;
            }
        }

        return true;
    }
}
