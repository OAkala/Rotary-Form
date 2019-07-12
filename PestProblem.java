/* 
   *************************************************************************************************
   Program: PestProblem.java
   Repository Name: Rotary-Form
   Date Created: 03-Jul-19
   Program Description: This is a field of the rotary form that holds the data on what pests were
   of concern in that unit.
   *************************************************************************************************
*/

import java.util.*;

public class PestProblem {
    private static final int NO_PESTS = 3;
    private boolean[] pests = new boolean[NO_PESTS];
    private String others;

    /**
     * PestProblem -
     * Default constructor. Initializes instance variables with default values
     */
    PestProblem() {
        others = "none";
        Arrays.fill(pests, false);
    }

    /**
     * getOthers -
     * Returns value of others field.
     *
     * @return -- String object
     */
    public String getOthers() {
        return others;
    }

    /**
     * setOthers -
     * Sets value of others field. If value is successfully set then it returns '1' otherwise it
     * returns '-1'
     *
     * @param others -- String object
     * @return -- int value
     */
    public int setOthers(String others) {
        if (!others.isEmpty()) {
            this.others = others;
            return 1;
        }
        System.out.println("Please enter valid response.");
        return -1;

    }

    /**
     * getPest -
     * Returns data representing the pests in the record
     *
     * @return -- boolean[]
     */
    private boolean[] getPest() {
        return pests;
    }

    /**
     * setPests -
     * Sets the data values for the boolean array representing the pests
     *
     * @param pestIndex -- Array index
     * @param bool      -- data value
     * @return -- int value
     */
    public int setPests(int pestIndex, boolean bool) {
        if (pestIndex < NO_PESTS) {
            pests[pestIndex] = bool;
            return 1;
        }
        return -1;
    }

    /**
     * toString -
     * This method returns a delimited string with all the data from the object
     *
     * @return -- String object
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (boolean bool : getPest()
        ) {
            str.append(bool);
            str.append(",");
        }
        str.append(getOthers());
        return str.toString();
    }
}
