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
    private CrapsDealer crapsDealer;
    private CrapsPlayer crapsPlayer;
    private CrapsGame crapsGame;
    private Dice dice;

    public CrapsGameEngine(User user) {
        this.crapsDealer = new CrapsDealer();
        this.crapsPlayer = new CrapsPlayer(user.getName(), user.getWallet());
        this.crapsGame = new CrapsGame();
        this.dice = new Dice(2, 6);
//        displayCrapsMenu();
    }

    public CrapsGameEngine(CrapsPlayer player) {
        this.crapsDealer = new CrapsDealer();
        this.crapsPlayer = player;
        this.crapsGame = new CrapsGame();
        this.dice = new Dice(2, 6);
//        displayCrapsMenu();
    }

    public void displayCrapsMenu() {
        Console.println("Welcome to Craps!");
        Integer choice = UserDisplay.displayOptions("Start Game", "Leave Table", "Show Rules");
        menuChoice(choice);
    }

    public String menuChoice(Integer choice) {
        String output;
        switch(choice) {
            case 1:
                // start game
                output = "run game";
                runGame();
                break;
            case 2:
                // leave table
                output = "leave table";
                leaveTable(crapsPlayer);
                break;
            case 3:
                // show rules
                output = "display rules";
                CrapsGame.showGameRules();
                displayCrapsMenu();
                break;
            default:
                output = "invalid response";
                Console.println("Invalid response");
        }
        return output;
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

//            Double reward = 0.00;
            switch(outcome) {
                case 0:
                    playerLose(outcome);
//                    Console.println("\n\nYou lost");
//                    Console.println("Your remaining balance is $%.2f", crapsPlayer.getWallet());
                    continueCraps = false;
                    break;
                case 1:
                    playerWin(outcome);
//                    reward = betAmount * 2;
//                    crapsPlayer.incrementWallet(reward);
//                    Console.println("\n\nYou won $%.2f", reward);
//                    Console.println("Your new balance is $%.2f", crapsPlayer.getWallet());
                    continueCraps = false;
                    break;
                default:
                    winRolls = gameContinue(outcome, winRolls);
                    loseRolls = laterLoseRolls;
            }
        }
        leaveTable(crapsPlayer);
    }

    public String generalGameEnd(Integer outcome) {
        String[] opts = {"lost", "won"};
        String[] opts2 = {"remaining", "new"};
        StringBuilder output = new StringBuilder();
        output.append(String.format("You %s Craps!\n", opts[outcome]));
        output.append(String.format("Your %s balance is $%.2f", opts2[outcome], crapsPlayer.getWallet()));
        Console.println(output.toString());
        return output.toString();
    }

    public void playerWin(Integer outcome) {
        payOutRewardToPlayer();
        generalGameEnd(outcome);
    }

    public void playerLose(Integer outcome) {
        generalGameEnd(outcome);
    }

    public Integer[] gameContinue(Integer rollValue, Integer[] winRolls) {
        if (winRolls == initialWinRolls) {
            Integer[] roll = {rollValue};
            winRolls = roll;
        }
        Console.println("\nGame continuing...\n");
        return winRolls;
    }

    public Double payOutRewardToPlayer() {
        Double reward = crapsPlayer.getBetAmount() * 2;
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
        Console.println(message.toString());
        return message.toString();
    }

    public Integer chooseGameOption(String option) {
        Integer choice = UserDisplay.displayOptions(option, "Leave table");
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
        Console.println("Receive 2X your wager if you win!");
        Double betAmount = 0.0;
        do {
            betAmount = Console.getDoubleInput("Enter your bet: ");
            crapsPlayer.setBetAmount(betAmount);
        } while (!crapsPlayer.verifyValidBetAmount(betAmount));
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

    public String leaveTable(CrapsPlayer player) {
        Console.println("Do you want to leave the table?");
        Integer option = UserDisplay.displayOptions("No, play again", "Yes, leave table");
        String output;
        switch(option) {
            case 1:
                output = "play again";
                CrapsGameEngine cge = new CrapsGameEngine(player);
                cge.displayCrapsMenu();
                break;
            default:
                output = "leave table";
                Casino casino = new Casino(player.getName(), player.getWallet());
                break;
        }
        return output;
    }

}
