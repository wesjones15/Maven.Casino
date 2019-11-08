package io.zipcoder.casino.games.DiceGames.craps;

import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Rules;

public class CrapsGame {
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

    public static String showGameRules() {
        Console.clear();
        String rules = Rules.craps;
        Console.println(rules);
        return rules;
    }
}
