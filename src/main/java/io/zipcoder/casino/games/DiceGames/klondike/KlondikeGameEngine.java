package io.zipcoder.casino.games.DiceGames.klondike;

import io.zipcoder.casino.sweetasscasinotools.Dice;
import io.zipcoder.casino.sweetasscasinotools.Die;
import io.zipcoder.casino.utilities.Casino;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.UserDisplay;


public class KlondikeGameEngine {

    private User user;
    private KlondikePlayer klondikePlayer;
    private KlondikeDealer klondikeDealer;
    private KlondikeGame klondikeGame;

    /*public KlondikeGameEngine(User user) {
        this.user = user;
        this.klondikePlayer = new KlondikePlayer(user);
        this.klondikeDealer = new KlondikeDealer();
        this.klondikeGame = new KlondikeGame();
    }*/

    public KlondikeGameEngine(User user) {
//        this.crapsDealer = new CrapsDealer();
        this.klondikePlayer = new KlondikePlayer(user.getName(), user.getWallet());
        this.klondikeDealer = new KlondikeDealer();

    }

    public KlondikeGameEngine(KlondikePlayer player) {
//        this.klondikeDealer = new KlondikeDealer();
        this.klondikePlayer = player;
        this.klondikeDealer = new KlondikeDealer();
//        this.klondikeGame = new KlondikeGame();
    }

    public Integer displayKlondikeMenu() {
        Console.println("Welcome to Klondike!");
        Integer choice = UserDisplay.displayOptions("Start New Game", "View Klondike Rules", "Leave Game");
        return choice;
    }

    public String executeActionChosen(Integer choice) {
        String optionChosen = "";
        switch (choice) {
            case 1:
                playKlondike();
                /*if (UserDisplay.displayOptions("Play Again", "Leave Table") == 1)
                    playKlondike();
                else
                    displayKlondikeMenu();*/
                optionChosen = "Start Klondike Game";
                break;
            case 2:
                displayKlondikeRules();
                displayKlondikeMenu();
                optionChosen = "Display Klondike Rules";
                break;
            case 3:
                leaveTable(klondikePlayer);
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
        Integer action = displayKlondikeMenu();
        executeActionChosen(action);
    }

    public void playKlondike() {
        Integer[] playerCounts;
        Integer[] dealerCounts;
        String winner;
        Double holdBet = 0.0;
        Boolean klondike = true;
        Double betAmount = 0.0;

        if (chooseGameOption("Set bet") == 1) {
            betAmount = promptForBetAmount();
        }

       /* Integer choice = UserDisplay.displayOptions("Roll", "Leave Table");
        if (choice == 1) {*/
        // Player Rolls
        Console.getStringInput("Press enter to roll");
        Integer[] playerFaceValues = getFaceValues(playerDieRoll().getDieArray());
        Console.println("Player Roll:");
        Console.println(printFaceValues(playerFaceValues));

        playerCounts = faceValueCount(playerFaceValues);

        // Dealer Rolls
        Integer[] dealerFaceValues = getFaceValues(dealerDieRoll().getDieArray());
        Console.println("Dealer Roll:");
        Console.println(printFaceValues(dealerFaceValues));
        dealerCounts = faceValueCount(dealerFaceValues);
        String winPerson = getWinner(dealerCounts, playerCounts);
        Console.println(winPerson);
        //}
        //compare rolls and getWinner
        if (winPerson.contains("Player")) {
            Double payout = betAmount*2;
            klondikePlayer.incrementWallet(payout);
            Console.println("You won $%.2f", payout);
        }
//        run();
        leaveTable(klondikePlayer);
    }
/*
    public Double promptForBetAmount() {
        Console.println("Receive 2X your wager if you win!");
        Double betAmount = 0.0;
        do {
            betAmount = Console.getDoubleInput("Enter your bet: ");
            klondikePlayer.setBetAmount(betAmount);
        } while (!klondikePlayer.verifyValidBetAmount(betAmount));
        klondikePlayer.placeBet(betAmount);
        Console.println("You are wagering $%.2f", betAmount);
        Console.println("Your remaining balance is $%.2f\n", klondikePlayer.getWallet());
        return betAmount;
    }*/

   /* public Integer promptUserToRollDice() {
        Integer rollValue = dice.rollAndSum();
        Console.println("\n\nYou rolled %s", rollValue);
        return rollValue;
    }*/

    public String printFaceValues(Integer[] dieFaceValues) {
        String result = "";
        for (Integer faceValue : dieFaceValues) {
            result += "  " + faceValue;
        }
        return result;
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

    public Boolean isFiveOfAKind(Integer[] faceValueCounts) {
        return getNumberOfOccurrences(faceValueCounts, 5) == 5;
    }

    public Boolean isFourOfAKind(Integer[] faceValueCounts) {
        return getNumberOfOccurrences(faceValueCounts, 4) == 4;
    }

    public Boolean isFullHouse(Integer[] faceValueCounts) {
        return getNumberOfOccurrences(faceValueCounts, 3) == 3 && getNumberOfOccurrences(faceValueCounts, 2) == 2;
    }


    public Boolean isThreeOfAKind(Integer[] faceValueCounts) {
        return getNumberOfOccurrences(faceValueCounts, 1) == 2;
    }

    public Boolean isTwoPair(Integer[] faceValueCounts) {
        // two pairs means there will be four counts of two in the counts of face values array
        return getNumberOfOccurrences(faceValueCounts, 2) == 4;
    }

    public Boolean isOnePair(Integer[] faceValueCounts) {
        // one pair means there will be two counts of two in the counts of face values array
        return getNumberOfOccurrences(faceValueCounts, 1) == 3;
    }

    public Integer checkRollSequence(Integer[] faceValueCounts) {
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


    public String getWinner(Integer[] dealerRollCounts, Integer[] playerRollCounts) {
        String winner;
        if (checkRollSequence(dealerRollCounts) >= checkRollSequence(playerRollCounts))
            winner = "Dealer Wins!";
        else
            winner = "Player Wins!";
        return winner;
    }

    //Supporting Methods

    public String displayKlondikeRules() {
        return "In Klondike Dice players need to roll better combination than banker to win. The banker rolls first and then all other players take turns to roll and try to beat banker’s combination.\n" +
                "\n" +
                "Combinations are ordered in sequence from highest to lowest as following\n" +
                "\n" +
                "Five of a kind – All 5 dice showing the same number\n" +
                "Four of a kind – 4 dice showing the same number\n" +
                "Full house – 3 dice with one number and 2 dice showing another number\n" +
                "Three of a kind – 4 dice showing the same number\n" +
                "Two pairs – 2 dice pairs showing same number\n" +
                "One pair – 2 dice showing same number\n" +
                "A die not used in any combination is ignored. If players roll same combination as of banker, then they lose. They must roll a better combination to win. In case no one rolls a combination including the banker, then banker wins.";
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
        for (int i = 0; i < counts.length; i++) {
            counts[i] = getNumberOfOccurrences(faceValues, faceValues[i]);
        }
        return counts;
    }

    public Integer chooseGameOption(String option) {
        Integer choice = UserDisplay.displayOptions(option, "Leave table");
        switch (choice) {
            case 1:
                // pass
                break;
            case 2:
                // leave table
                //leaveTable(crapsPlayer);
                break;
            default:
                Console.println("Invalid Option");
        }
        return choice;
    }

    public Double promptForBetAmount() {
        Console.println("Receive 2X your wager if you win!");
        Double betAmount = 0.0;
        do {
            betAmount = Console.getDoubleInput("Enter your bet: ");
            klondikePlayer.setBetAmount(betAmount);
        } while (!klondikePlayer.verifyValidBetAmount(betAmount));
        klondikePlayer.placeBet(betAmount);
        Console.println("You are wagering $%.2f", betAmount);
        Console.println("Your remaining balance is $%.2f\n", klondikePlayer.getWallet());
        return betAmount;
    }

    public String leaveTable(KlondikePlayer player) {
        Console.println("Do you want to leave the table?");
        Integer option = UserDisplay.displayOptions("No, play again", "Yes, leave table");
        String output;
        switch(option) {
            case 1:
                output = "play again";
                KlondikeGameEngine kge = new KlondikeGameEngine(player);
                kge.run();
                break;
            default:
                output = "leave table";
                Casino casino = new Casino(player.getName(), player.getWallet());
                break;
        }
        return output;
    }


}

