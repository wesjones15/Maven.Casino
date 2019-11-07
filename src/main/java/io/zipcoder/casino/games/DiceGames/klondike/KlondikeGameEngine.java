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

public KlondikeGameEngine(){

}
    public KlondikeGameEngine(User user) {
        this.klondikePlayer = new KlondikePlayer(user.getName(), user.getWallet());
        this.klondikeDealer = new KlondikeDealer();

    }

    public KlondikeGameEngine(KlondikePlayer player) {
        this.klondikePlayer = player;
        this.klondikeDealer = new KlondikeDealer();
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
                if (klondikePlayer.getWallet() > 0) {
                    playKlondike();
                    optionChosen = "Start Klondike Game";
                } else {
                    Console.print("You do not have enough money for the minimum bet of $0.01!\n");
                    leaveTable(klondikePlayer);
                }
                break;
            case 2:
                KlondikeGame.displayKlondikeRules();
                displayKlondikeMenu();
                optionChosen = "Display Klondike Rules";
                break;
            case 3:
                leaveTable(klondikePlayer);
                optionChosen = "Leave Game";
                break;
            default:
                Console.println("Invalid response!");
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

        Double betAmount = promptForBetAmount();

        Console.getStringInput("Press enter to roll");

        // Dealer Roll
        Integer[] dealerFaceValues = KlondikeGame.getFaceValues(KlondikeGame.dieRoll().getDieArray());
        Console.println("Dealer Roll:");
        Console.println(KlondikeGame.printFaceValues(dealerFaceValues) + '\n');
        //dealerCounts = KlondikeGame.faceValueCount(dealerFaceValues);

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

    public String getWinner(Integer[] dealerRollCounts, Integer[] playerRollCounts) {
        String winner;
        if (KlondikeGame.checkRollSequence(dealerRollCounts) >= KlondikeGame.checkRollSequence(playerRollCounts))
            winner = "Dealer Wins!\n";
        else
            winner = "Player Wins!\n";
        return winner;
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

