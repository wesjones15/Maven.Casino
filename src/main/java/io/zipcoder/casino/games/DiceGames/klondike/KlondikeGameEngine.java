package io.zipcoder.casino.games.DiceGames.klondike;

import io.zipcoder.casino.sweetasscasinotools.Dice;
import io.zipcoder.casino.sweetasscasinotools.Die;
import io.zipcoder.casino.utilities.Casino;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.userandplayer.User;

import java.util.ArrayList;
import java.util.Arrays;


public class KlondikeGameEngine {

    private User user;
    private KlondikePlayer klondikePlayer;
    private KlondikeDealer klondikeDealer;
    private KlondikeGame klondikeGame;

    public KlondikeGameEngine(User user) {
        this.user = user;
        this.klondikePlayer = new KlondikePlayer(user);
        this.klondikeDealer = new KlondikeDealer();
        this.klondikeGame = new KlondikeGame();
    }

    public void displayKlondikeMenu() {
        Console.println("Welcome to Klondike!\n" +
                "1 : Start Game\n" +
                "2 : View Klondike Rules\n" +
                "3 : Leave Game");
    }

    public Integer choiceFromKlondikeMenu() {
        Integer choice = Console.getIntegerInput("What do you want to do?");
        return choice;
    }

    public String executeActionChosen(Integer choice) {
        String optionChosen = "";
        switch (choice) {
            case 1:
                //runKlondike();
                optionChosen = "Start Klondike Game";
                break;
            case 2:
                //displayKlondikeRules();
                optionChosen = "Display Klondike Rules";
                break;
            case 3:
                //leaveGame();
                optionChosen = "Leave Game";
                break;
            default:
                //Console.println("Invalid response!");
                displayKlondikeMenu();
                optionChosen = "Re-route player to main Klondike menu";
                break;
        }
        return optionChosen;
    }

    public void run() {
        displayKlondikeMenu();
        Integer action = choiceFromKlondikeMenu();
        executeActionChosen(action);
    }

    public Dice runKlondike() {

        // retrieve face value from dealer roll
        Integer[] dealerFaceValues = getFaceValues(dealerDieRoll().getDieArray());
        // get numOfOccurrences for each face value
        Integer[] dealerCounts = faceValueCount(dealerFaceValues);
        // retrieve face value from player roll
        Integer[] playerFaceValues = getFaceValues(playerDieRoll().getDieArray());
        Integer[] playerCounts = faceValueCount(playerFaceValues);
        //compare rolls
        //getWinner()
        return null;
    }

    public Dice dealerDieRoll() {
        Dice dealerDice = new Dice(5, 6);
        for (int i = 0; i < dealerDice.getDieArray().length; i++) {
            dealerDice.getDie(i).roll();
        }
        return dealerDice;
    }


    public Dice playerDieRoll() {
        Dice playerDice = new Dice(5, 6);
        for (int i = 0; i < playerDice.getDieArray().length; i++) {
            playerDice.getDie(i).roll();
        }
        return playerDice;
    }

    public Boolean isFiveOfAKind(Integer[] faceValueCount) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(faceValueCount));
        return list.contains(5);
    }

    public Boolean isFourOfAKind(Integer[] faceValueCount) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(faceValueCount));
        return list.contains(4);
    }

    public Boolean getWinner() {
        return null;
    }

    //Supporting Methods

    public String displayKlondikeRules() {
        return null;
    }

    // Calculate the number of times a certain face value occurs
    public Integer getNumberOfOccurrences(Integer[] faceValuesArray, Integer value) {
        int numOfOccurrences = 0;
        for (Integer faceValue : faceValuesArray) {
            if (faceValue == value)
                numOfOccurrences = numOfOccurrences + 1;
        }
        return numOfOccurrences;
    }

    // Retrieve face values from array of five die
    public Integer[] getFaceValues(Die[] dieArray) {
        Integer[] faceValuesArray = new Integer[5];
        for (int i = 0; i < faceValuesArray.length; i++) {
            faceValuesArray[i] = dieArray[i].getCurrentFacesValue();
        }
        return faceValuesArray;
    }

    public Integer[] faceValueCount(Integer[] faceValues) {
        Integer[] counts = new Integer[5];
        //int face = 1;
        for (int i = 0; i < counts.length; i++) {
            //face+=1;
            counts[i] = getNumberOfOccurrences(faceValues, faceValues[i]);
            //face = face + 1;
        }
        return counts;
    }

}

