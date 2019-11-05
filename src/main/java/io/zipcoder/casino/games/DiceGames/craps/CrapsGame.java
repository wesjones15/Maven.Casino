package io.zipcoder.casino.games.DiceGames.craps;


import io.zipcoder.casino.sweetasscasinotools.Dice;
import io.zipcoder.casino.utilities.Console;

public class CrapsGame {

    private Dice dice;

//    public CrapsGame() {
//    }

//    public Boolean checkMatch(int playerRollValue, int numToCheck) {
//        return null;
//    }
    //pulling methods from gambling game and game interface

    public static Integer determineRollOutcome(Integer rollValue, Integer[] winRolls, Integer[] loseRolls) {
        Integer outcome;
        if (checkRollMatch(rollValue, winRolls)) {
            outcome = 1;            // win
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

    public static void showGameRules() {
        Console.clear();
        String rules = "---==--===--===--==| CRAPS RULES |==--===--===--==---\nOn the first round, you win if you roll a 7 or 12\nand you lose if you roll a 2, 3, or 12" +
                "\nIf you roll something else, that number becomes\nyour win target and your losing roll becomes 7" +
                "\nYou can wager your money on whether you win the round\n" +
                "---==--===--===--========-=-========--===--===--==---\n";
        Console.println(rules);
    }
}
