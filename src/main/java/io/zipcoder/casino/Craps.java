package io.zipcoder.casino;

public class Craps {
//    private final static Integer[] initialWinRolls = {7, 11};
//    private final static Integer[] initialLoseRolls = {2, 3, 12};


    public static void runCraps() {
        // initialize craps player; CrapsPlayer player = user (pass userId in params)
        // set player wallet to userwallet
        // prompt user to set bet amount
        // deduct that amount from player wallet -= betAmount
        // prompt user for action: 1 rolldice / 2 leave table / 3...
        // if leave table: break; end game; set user wallet = player wallet
        // if rolldice:
        // determineRollOutcome(rollValue, winRolls, loseRolls)
        // if outcome continue:
        // if win player wallet += CrapsDealer.getPot (betAmount*2)
        // if lose

//        Integer numToCheck = 7;
//        boolean continueCraps = true;
//        Integer rollValue = 0; //rollDice();
//        Integer[] winRolls = initialWinRolls;
//        Integer[] loseRolls = initialLoseRolls;
//        while (continueCraps) {

            //prompt user to roll dice
                //check rollValue = 7 -> lose : continueCraps = false
                //check rollValue = numToCheck -> win : continueCraps = false
                //else repeat while loop
//            else {
//                winRolls = numToCheck;
//                loseRolls = {7};
//            }
//        }
    }

//    public static Integer crapsTurn(Integer[] numToCheck) {
//         prompt user to set bet
//        Integer rollValue = 0; //rollDice();
//        Integer[] winRolls = { numToCheck };
//        Integer[] loseRolls = { 7 };
//        return determineRollOutcome(rollValue, winRolls, loseRolls);
//
//    }

//    public static Integer determineRollOutcome(Integer rollValue, Integer[] winRolls, Integer[] loseRolls) {
//        Integer outcome;
//        if (checkRollMatch(rollValue, winRolls)) {
//            outcome = 1;            // win
//            // deduct amount from player wallet
//        }
//        else if (checkRollMatch(rollValue, loseRolls)) {
//            outcome = 0;            // lose
//        }
//        else {
//            outcome = rollValue;    // continue
//        }
//        return outcome;
//    }
//
//    public static Boolean checkRollMatch(Integer rollValue, Integer... numsToCheck) {
//        Boolean match = false;
//        for (Integer num : numsToCheck) {
//            if (num == rollValue) {
//                match = true;
//                break;
//            }
//        }
//        return match;
//    }

//    public static void setNumToCheck(Integer numToCheck) {
//        //
//    }



}
