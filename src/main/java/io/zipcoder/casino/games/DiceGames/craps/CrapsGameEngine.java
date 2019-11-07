package io.zipcoder.casino.games.DiceGames.craps;

import io.zipcoder.casino.sweetasscasinotools.Dice;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.Casino;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.UserDisplay;

public class CrapsGameEngine {
    private final Integer[] initialWinRolls = {7, 11};
    private final Integer[] initialLoseRolls = {2, 3, 12};
    private final Integer[] laterLoseRolls = {7};

    private Integer[] winRolls;
    private Integer[] loseRolls;

    private CrapsPlayer crapsPlayer;
    private Dice dice;

    public CrapsGameEngine(User user) {
        this.crapsPlayer = new CrapsPlayer(user.getName(), user.getWallet());
        this.dice = new Dice(2, 6);
        this.winRolls = initialWinRolls;
        this.loseRolls = initialLoseRolls;
    }

    public CrapsGameEngine(CrapsPlayer player) {
        this.crapsPlayer = player;
        this.dice = new Dice(2, 6);
        this.winRolls = initialWinRolls;
        this.loseRolls = initialLoseRolls;
    }

    public void run() {
        Double betAmount = 0.00;
        Integer rollValue;

        displayCrapsMenu();

        Integer choice = UserDisplay.displayOptions("Start Game", "Leave Table", "Show Rules"); // user input
        Boolean continueCraps = executeMenuChoice(choice);

        if (continueCraps) {
            betAmount = promptUserForBetAmount(); // user input
            displayBetInfo(betAmount, crapsPlayer.getWallet());
        }

        while(continueCraps) {
            continueCraps = false;

            displayRollsAndBetAmount(winRolls, loseRolls, betAmount);

//            chooseGameOption("Roll dice");
//            rollValue = dice.rollAndSum();

            choice = chooseGameOption("Roll dice"); // user input
            rollValue = executeDiceRoll(choice);
            displayDiceRoll(rollValue);

            Integer outcome = CrapsGame.determineRollOutcome(rollValue, winRolls, loseRolls);

            if (outcome > 1) {
                updateRollConditions(rollValue);
                Console.println("\nGame continuing...\n");
                continueCraps = true;
            } else {
                generalGameEnd(outcome, crapsPlayer.getWallet());
                if (outcome == 1) payOutRewardToPlayer(crapsPlayer.getBetAmount());
            }
        }
        leaveTable(crapsPlayer); // user input
    }



    public String displayCrapsMenu() {
        String message = "Welcome to Craps!";
        Console.println(message);
        return message;
    }

    public Boolean executeMenuChoice(Integer choice) {
        Boolean continueCraps = false;
        switch(choice) {
            case 1:     // start game
                continueCraps = true;
                break;
            case 2:     // leave table
                continueCraps = false;
                break;
            case 3:     // show rules
                CrapsGame.showGameRules();
//                continueCraps = true;
                run();
                break;
        }
        return continueCraps;
    }

    public String generalGameEnd(Integer outcome, Double wallet) {
        String[] opts = {"lost", "won"};
        String[] opts2 = {"remaining", "new"};

        StringBuilder output = new StringBuilder();
        output.append(String.format("You %s Craps!\n", opts[outcome]));
        output.append(String.format("Your %s balance is $%.2f\n", opts2[outcome], wallet));

        Console.println(output.toString());
        return output.toString();
    }

    public String displayRollsAndBetAmount(Integer[] winRolls, Integer[] loseRolls, Double betAmount) {
        StringBuilder output = new StringBuilder();
        output.append(showRollsForOutcome("Winning", winRolls) + "\n");
        output.append(showRollsForOutcome("Losing", loseRolls) + "\n");
        output.append(String.format("Current Wager: $%.2f", betAmount));
        Console.println(output.toString());
        return output.toString();
    }

    public Double payOutRewardToPlayer(Double betAmount) {
        Double reward = betAmount * 2;
        Console.println("You received $%.2f", reward);
        crapsPlayer.incrementWallet(reward);
        return reward;
    }

    public String showRollsForOutcome(String outcome, Integer... rollValues) {
        StringBuilder message = new StringBuilder();
        message.append(String.format("%s Rolls:", outcome));
        for (int i = 0; i < rollValues.length; i++) {
            message.append("\t"+rollValues[i]);
        }
        return message.toString();
    }

    public Integer chooseGameOption(String option) {
        Integer choice = UserDisplay.displayOptions(option, "Leave table");
        switch(choice) {
            case 1:     // pass
                break;
            case 2:     // leave table
                leaveTable(crapsPlayer);
                break;
            default:
                Console.println("Invalid Option");
        }
        return choice;
    }

    public Double promptUserForBetAmount() {
        Console.println("Receive 2X your wager if you win!");
        Double betAmount;
        do {
            betAmount = Console.getDoubleInput("Enter your bet: ");
        } while (!crapsPlayer.verifyValidBetAmount(betAmount));
        crapsPlayer.placeBet(betAmount);
        return betAmount;
    }

    public String displayBetInfo(Double betAmount, Double wallet) {
        StringBuilder message = new StringBuilder();
        message.append(String.format("You are wagering $%.2f\n", betAmount));
        message.append(String.format("Your remaining balance is $%.2f\n", wallet));
        Console.println(message.toString());
        return message.toString();
    }

    public Integer executeDiceRoll(Integer choice) {
        Integer rollValue = 0;
        if (choice == 1) {
            rollValue = dice.rollAndSum();
        }
        return rollValue;
    }

    public String displayDiceRoll(Integer rollValue) {
        String message = String.format("\n\nYou rolled %s", rollValue);
        Console.println(message);
        return message;
    }

    public String leaveTable(CrapsPlayer player) { //   not testable unless rewritten due to input and dispatch
        Console.println("Do you want to leave the table?");
        Integer option = UserDisplay.displayOptions("No, play again", "Yes, leave table");
        String output;
        switch(option) {
            case 1:
                output = "play again";
                CrapsGameEngine cge = new CrapsGameEngine(player);
                cge.run();
                break;
            default:
                output = "leave table";
                Casino casino = new Casino(player.getName(), player.getWallet());
                break;
        }
        return output;
    }

    public Integer[] updateRollConditions(Integer... newWinRoll) {
        this.winRolls = newWinRoll;
        this.loseRolls = laterLoseRolls;
        return this.winRolls;
    }

}
