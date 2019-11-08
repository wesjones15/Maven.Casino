package io.zipcoder.casino.games.DiceGames.klondike;

import io.zipcoder.casino.utilities.Art;
import io.zipcoder.casino.utilities.Casino;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.UserDisplay;


public class KlondikeGameEngine {
    private KlondikePlayer klondikePlayer;


    public KlondikeGameEngine(User user) {
        this.klondikePlayer = new KlondikePlayer(user.getName(), user.getWallet());
    }

    public KlondikeGameEngine(KlondikePlayer player) {
        this.klondikePlayer = player;
    }

    public void executeActionChosen(Integer choice) {
        switch (choice) {
            case 1:
                if (klondikePlayer.getWallet() > 0) {
                    playKlondike();
                } else {
                    Console.print("You do not have enough money for the minimum bet of $0.01!\n");
                    leaveTable(klondikePlayer);
                }
                break;
            case 2:
                Console.print(KlondikeGame.displayKlondikeRules());
                run();
                break;
            case 3:
                leaveTable(klondikePlayer);
                break;
            default:
                Console.println("Invalid response!");
                break;
        }
    }

    public void run() {
        displayKlondikeMenu();
        Integer action = UserDisplay.displayOptions("Start New Game", "View Klondike Rules", "Leave Game");
        executeActionChosen(action);
    }

    public String displayKlondikeMenu() {
        String message = "Welcome to\n" + Art.klondikeSign;
//        Integer choice = UserDisplay.displayOptions("Start New Game", "View Klondike Rules", "Leave Game");
        Console.println(message);
        return message;
    }

    public void playKlondike() {

        Double betAmount = promptForBetAmount();

        Console.getStringInput("Press enter to roll");

        // Dealer Roll
        Integer[] dealerFaceValues = KlondikeGame.getFaceValues(KlondikeGame.dieRoll().getDieArray());
        Console.println("Dealer Roll:");
        Console.println(KlondikeGame.printFaceValues(dealerFaceValues) + '\n');

        // Player Roll
        Integer[] playerFaceValues = KlondikeGame.getFaceValues(KlondikeGame.dieRoll().getDieArray());
        Console.println("Player Roll:");
        Console.println(KlondikeGame.printFaceValues(playerFaceValues) + '\n');

        // Display winner
        String winPerson = getWinner(KlondikeGame.faceValueCount(dealerFaceValues),KlondikeGame.faceValueCount(playerFaceValues));
        Console.println(winPerson);

        //compare rolls and getWinner
        if (winPerson.contains("Player")) {
            Double payout = betAmount * 2;
            klondikePlayer.incrementWallet(payout);
            Console.println("You won $%.2f", payout);
        }

        leaveTable(klondikePlayer);
    }

    public Double promptForBetAmount() {
        Console.println("Receive 2X your wager if you win!");
        Double betAmount = 0.0;
        do {
            betAmount = Console.getDoubleInput("Enter your bet: ");
        } while (!klondikePlayer.verifyValidBetAmount(betAmount));
        klondikePlayer.placeBet(betAmount);
        Console.println("You are wagering $%.2f", betAmount);
        Console.println("Your remaining balance is $%.2f\n", klondikePlayer.getWallet());
        return betAmount;
    }

    public String getWinner(Integer[] dealerRollCounts, Integer[] playerRollCounts) {
        String winner;
        if (KlondikeGame.checkRollSequence(dealerRollCounts) >= KlondikeGame.checkRollSequence(playerRollCounts))
            winner = "Dealer Wins!\n";
        else
            winner = "Player Wins!\n";
        return winner;
    }

    public String leaveTable(KlondikePlayer player) {
        Console.println("Do you want to leave the table?");
        Integer option = UserDisplay.displayOptions("No, play again", "Yes, leave table");
        String output;
        switch (option) {
            case 1:
                output = "play again";
                KlondikeGameEngine kge = new KlondikeGameEngine(player);
                kge.run();
                break;
            default:
                output = "leave table";
                new Casino(player.getName(), player.getWallet());
                break;
        }
        return output;
    }
}

