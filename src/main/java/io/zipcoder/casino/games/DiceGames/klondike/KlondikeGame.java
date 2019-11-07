package io.zipcoder.casino.games.DiceGames.klondike;


import io.zipcoder.casino.sweetasscasinotools.Dice;
import io.zipcoder.casino.sweetasscasinotools.Die;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.Console;

public class KlondikeGame {

    /*private int numOfDie;
    private int numOfFaces;
    private Dice dice;
    private User user;
    private KlondikePlayer klondikePlayer;
    private KlondikeDealer klondikeDealer;
    private KlondikeGame klondikeGame;
*/

  /*  public KlondikeGame() {
        this.numOfDie = 5;
        this.numOfFaces = 6;
        this.dice = new Dice(numOfDie, numOfFaces);
    }*/

    /*public KlondikeGame(User user) {
        this.klondikePlayer = new KlondikePlayer(user.getName(), user.getWallet());
        this.klondikeDealer = new KlondikeDealer();
    }

    public KlondikeGame(KlondikePlayer player) {
        this.klondikePlayer = player;
        this.klondikeDealer = new KlondikeDealer();
    }*/

    //pulling methods from gambling game and game interface

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

    public static Dice dealerDieRoll() {
        Dice dealerDice = new Dice(5, 6);
        for (int i = 0; i < dealerDice.getDieArray().length; i++) {
            dealerDice.getDie(i).roll();
        }
        return dealerDice;
    }

    public static Dice playerDieRoll() {
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

    public static void displayKlondikeRules() {
        Console.print("In Klondike Dice players need to roll better combination than banker to win.\n" +
                "The banker rolls first and the player rolls and tries to beat banker’s combination.\n" +
                "\n" +
                "Combinations are ordered in sequence from highest to lowest as follows\n" +
                "\n" +
                "Five of a kind – All 5 dice showing the same number\n" +
                "Four of a kind – 4 dice showing the same number\n" +
                "Full house – 3 dice with one number and 2 dice showing another number\n" +
                "Three of a kind – 4 dice showing the same number\n" +
                "Two pairs – 2 dice pairs showing same number\n" +
                "One pair – 2 dice showing same number\n" +
                "A die not used in any combination is ignored. If players roll same combination as of banker, then they lose.\n" +
                "They must roll a better combination to win. In case no one rolls a combination including the banker, then banker wins.");
    }
}
