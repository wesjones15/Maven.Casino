package io.zipcoder.casino;

public class Craps {

    public static void runCraps() {

        Integer numToCheck = 7;
        boolean continueCraps = true;
//        first roll occurs before entering while loop
//        set continueCraps boolean based on result of first roll
//        if user rolls 7 or 11 -> win  : ask if play again
//        else if check 2, 3, 12 -> lose: ask if play again
//        else set numToCheck = rollValue; reset rollValue; enter while loop

        while (continueCraps) {
            //prompt user to set bet
            //prompt user to roll dice
                //check rollValue = 7 -> lose : continueCraps = false
                //check rollValue = numToCheck -> win : continueCraps = false
                //else repeat while loop
            continueCraps = false;
        }
    }

    public static Boolean checkRollMatch(Integer rollValue, Integer numToCheck) {
        return (rollValue == numToCheck);
    }

//    public static void setNumToCheck(Integer numToCheck) {
//        //
//    }



}
