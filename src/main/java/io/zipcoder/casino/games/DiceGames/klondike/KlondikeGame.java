package io.zipcoder.casino.games.DiceGames.klondike;

import io.zipcoder.casino.sweetasscasinotools.Dice;
import io.zipcoder.casino.sweetasscasinotools.Die;
import io.zipcoder.casino.utilities.Rules;

public class KlondikeGame {

    public static Integer checkRollSequence(Integer[] faceValueCounts) {
        int winPoints;
        if (isFiveOfAKind(faceValueCounts))
            winPoints = 5;
        else if (isFourOfAKind(faceValueCounts))
            winPoints = 4;
        else if (isFullHouse(faceValueCounts))
            winPoints = 3;
        else if (isThreeOfAKind(faceValueCounts))
            winPoints = 2;
        else if (isTwoPair(faceValueCounts))
            winPoints = 1;
        else
            winPoints = 0;
        return winPoints;
    }

    public static String printFaceValues(Integer[] dieFaceValues) {
        String result = "";
        for (Integer faceValue : dieFaceValues) {
            result += "  " + faceValue;
        }
        return result;
    }

    public static Dice dieRoll() {
        Dice playerDice = new Dice(5, 6);
        for (int i = 0; i < playerDice.getDieArray().length; i++) {
            playerDice.getDie(i).roll();
        }
        return playerDice;
    }

    // Retrieve face values from array of five die
    public static Integer[] getFaceValues(Die[] dieArray) {
        Integer[] faceValuesArray = new Integer[5];
        for (int i = 0; i < faceValuesArray.length; i++) {
            faceValuesArray[i] = dieArray[i].getCurrentFacesValue();
        }
        return faceValuesArray;
    }

    public static Integer[] faceValueCount(Integer[] faceValues) {
        Integer[] counts = new Integer[5];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = getNumberOfOccurrences(faceValues, faceValues[i]);
        }
        return counts;
    }

    // Calculate the number of times a certain face value occurs
    public static Integer getNumberOfOccurrences(Integer[] faceValuesArray, Integer value) {
        int numOfOccurrences = 0;
        for (Integer faceValue : faceValuesArray) {
            if (faceValue == value)
                numOfOccurrences = numOfOccurrences + 1;
        }
        return numOfOccurrences;
    }

    public static Boolean isFiveOfAKind(Integer[] faceValueCounts) {
        return getNumberOfOccurrences(faceValueCounts, 5) == 5;
    }

    public static Boolean isFourOfAKind(Integer[] faceValueCounts) {
        return getNumberOfOccurrences(faceValueCounts, 4) == 4;
    }

    public static Boolean isFullHouse(Integer[] faceValueCounts) {
        return getNumberOfOccurrences(faceValueCounts, 3) == 3 && getNumberOfOccurrences(faceValueCounts, 2) == 2;
    }

    public static Boolean isThreeOfAKind(Integer[] faceValueCounts) {
        return getNumberOfOccurrences(faceValueCounts, 1) == 2;
    }

    public static Boolean isTwoPair(Integer[] faceValueCounts) {
        return getNumberOfOccurrences(faceValueCounts, 2) == 4;
    }

    public static Boolean isOnePair(Integer[] faceValueCounts) {
        return getNumberOfOccurrences(faceValueCounts, 1) == 3;
    }

    public static String displayKlondikeRules() {
        String rules = Rules.klondike;
        return rules;
    }
}
