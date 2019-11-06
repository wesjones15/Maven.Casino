package io.zipcoder.casino.games.DiceGames.craps;

import io.zipcoder.casino.*;


import io.zipcoder.casino.sweetasscasinotools.Dice;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.Casino;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.UserDisplay;

public class CrapsGameEngine {
    private final Integer[] initialWinRolls = {7, 11};
    private final Integer[] initialLoseRolls = {2, 3, 12};

    private CrapsDealer crapsDealer;
    private CrapsPlayer crapsPlayer;
    private CrapsGame crapsGame;
    private Dice dice;

    public CrapsGameEngine(User user) {
        this.crapsDealer = new CrapsDealer();
        this.crapsPlayer = new CrapsPlayer(user.getName(), user.getWallet());
        this.crapsGame = new CrapsGame();
        this.dice = new Dice(2, 6);
        displayCrapsMenu();
    }

    public CrapsGameEngine(CrapsPlayer player) {
        this.crapsDealer = new CrapsDealer();
        this.crapsPlayer = player;
        this.crapsGame = new CrapsGame();
        this.dice = new Dice(2, 6);
        displayCrapsMenu();
    }

    public void displayCrapsMenu() {
        Console.println("Welcome to Craps!");
        Integer choice = UserDisplay.displayOptions("Start Game", "Leave Table", "Show Rules");
        menuChoice(choice);
    }

    public void menuChoice(Integer choice) {
        switch(choice) {
            case 1:
                // start game
                runGame();
                break;
            case 2:
                // leave table
                leaveTable(crapsPlayer);
                break;
            case 3:
                // show rules
                CrapsGame.showGameRules();
                displayCrapsMenu();
                break;
            default:
                Console.println("Invalid response");
        }
    }

    public void runGame() {
        boolean continueCraps = true;
        Double betAmount = 0.00;
        Integer rollValue = 0;


        Integer[] winRolls = initialWinRolls;
        Integer[] loseRolls = initialLoseRolls;
        if (chooseGameOption("Set bet") == 1) {
            betAmount = promptUserForBetAmount();
        }
        while (continueCraps) {
            showRollsForOutcome("Winning", winRolls);
            showRollsForOutcome("Losing", loseRolls);
            Console.println("Current Wager: $%.2f", betAmount);
            if (chooseGameOption("Roll dice") == 1) {
                rollValue = promptUserToRollDice();
            }

            Integer outcome = CrapsGame.determineRollOutcome(rollValue, winRolls, loseRolls);
            if (outcome == 0) {
                // lose
                Console.println("\n\nYou lost");
                Console.println("Your remaining balance is $%.2f", crapsPlayer.getWallet());
                continueCraps = false;
            } else if (outcome == 1) {
                // win
                Double reward = betAmount * 2;
                crapsPlayer.incrementWallet(reward);
                Console.println("\n\nYou won $%.2f", reward);
                Console.println("Your new balance is $%.2f", crapsPlayer.getWallet());
                continueCraps = false;
            } else {
                if (winRolls.length > 1) {
                    Integer[] roll = {rollValue};
                    winRolls = roll;
                }
                Integer[] lose = {7};
                loseRolls = lose;
                Console.println("\nGame continuing...\n");
            }
        }
        leaveTable(crapsPlayer);
    }

    public void showRollsForOutcome(String outcome, Integer... rollValues) {
        StringBuilder message = new StringBuilder();
        message.append(String.format("%s Rolls:", outcome));
        for (int i = 0; i < rollValues.length; i++) {
            message.append("\t"+rollValues[i]);
        }
        Console.println(message.toString());
    }

    public Integer chooseGameOption(String option) {
        Integer choice = UserDisplay.displayOptions(option, "leave table");
        switch(choice) {
            case 1:
                // pass
                break;
            case 2:
                // leave table
                leaveTable(crapsPlayer);
                break;
            default:
                Console.println("Invalid Option");
        }
        return choice;
    }

    public Double promptUserForBetAmount() {
        Console.println("Bet condition: win bet if rollValue = winRoll");
        Double betAmount = 0.0;
        do {
            betAmount = Console.getDoubleInput("Enter your bet: ");
            crapsPlayer.setBetAmount(betAmount);
        } while (!crapsPlayer.verifyValidBetAmount());
        crapsPlayer.placeBet(betAmount);
        Console.println("You are wagering $%.2f", betAmount);
        Console.println("Your remaining balance is $%.2f\n", crapsPlayer.getWallet());
        return betAmount;
    }

    public Integer promptUserToRollDice() {
        Integer rollValue = dice.rollAndSum();
        Console.println("\n\nYou rolled %s", rollValue);
        return rollValue;
    }

    public void leaveTable(CrapsPlayer player) {
        Console.println("Are you sure you want to leave?");
        Integer option = UserDisplay.displayOptions("No, play again", "Yes, leave table");
        switch(option) {
            case 1:
                CrapsGameEngine cge = new CrapsGameEngine(player);
                break;
            default:
                Casino casino = new Casino(player.getName(), player.getWallet());
                break;
        }
    }

}
