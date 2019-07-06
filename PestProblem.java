/* 
   *************************************************************************************************
   Program: PestProblem.java
   Repository Name: Rotary-Form
   Date Created: 03-Jul-19
   Program Description: This is a field of the rotary form that holds the data on what pests were
   of concern in that unit

   *************************************************************************************************
*/

import java.util.*;

public class PestProblem {
    private static final int NO_PESTS = 3;
    private boolean[] pests = new boolean[NO_PESTS];
    private String others;

    public PestProblem() {
        others = "none";
        Arrays.fill(pests, false);
    }

    public String getOthers() {
        return others;
    }

    public int setOthers(String others) {
        if (!others.isEmpty()) {
            this.others = others;
            return 1;
        }
        System.out.println("Please enter valid response.");
        return -1;

    }

    public boolean[] getPest() {
        return pests;
    }

    public void setPests(int pestIndex, boolean bool) {
        if (pestIndex < NO_PESTS) {
            pests[pestIndex] = bool;
        }
    }

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
