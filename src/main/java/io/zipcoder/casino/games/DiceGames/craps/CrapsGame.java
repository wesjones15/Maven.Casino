package io.zipcoder.casino.games.DiceGames.craps;


import io.zipcoder.casino.sweetasscasinotools.Dice;

public class CrapsGame {

    private Dice dice;

    public CrapsGame() {
    }

//    public Boolean checkMatch(int playerRollValue, int numToCheck) {
//        return null;
//    }
    //pulling methods from gambling game and game interface

    public static Integer determineRollOutcome(Integer rollValue, Integer[] winRolls, Integer[] loseRolls) {
        Integer outcome;
        if (checkRollMatch(rollValue, winRolls)) {
            outcome = 1;            // win

            // deduct amount from player wallet
        }
        else if (checkRollMatch(rollValue, loseRolls)) {
            outcome = 0;            // lose
        }
        else {
            outcome = rollValue;    // continue
        }
        return outcome;
    }
    public static Boolean checkRollMatch(Integer rollValue, Integer... numsToCheck) {
        Boolean match = false;
        for (Integer num : numsToCheck) {
            if (num == rollValue) {
                match = true;
                break;
            }
        }
        return match;
    }

//    public static void
}
