package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.games.CardGames.Hand;
import io.zipcoder.casino.sweetasscasinotools.Deck;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.*;

public class BlackJackGame {
    private BlackJackDealer blackJackDealer;
    private BlackJackPlayer player;
    private Deck deck;


    public BlackJackGame(User user){
        this.blackJackDealer = new BlackJackDealer();
        this.player = new BlackJackPlayer(user.getName(), user.getWallet());
        this.deck = new Deck();
    }
    public BlackJackGame(BlackJackPlayer player) {
        this.blackJackDealer = new BlackJackDealer();
        this.player = new BlackJackPlayer(player.getName(), player.getWallet());
        this.deck = new Deck();
    }

    public void displayBlackJackMenu() {
        menuChoice(Console.getStringInput("\tWelcome to\n" + Art.bjTitle + "\n\n" + "\t\tType Your [SELECTION]\n\n" + "\t\t\t[DEAL] Hand\n" + "\t\t\t[VIEW] Rules\n" + "\t\t\t[LEAVE] Table\n" + "_________________________________________________"));
        //string escape
    }
    private String menuChoice(String choice) {
        String output;
        switch (choice.toUpperCase()) {
            case "DEAL":
                output = "deal cards to begin game";
                run();
                break;
            case "VIEW":
                output = "display rules";
                BlackJackGame.showGameRules();
                displayBlackJackMenu();
            case "LEAVE":
                output = "leave table";
//                leaveTable(blackJackPlayer);
                leaveTable(player);
                break;
            default:
                output = "invalid response";
                Console.println("Invalid input, try again!");
        }
        return output;
    }
    public void run() {
        Boolean dealerDone = false;
        Boolean playerStand = false;
        Double betAmount = 0.00;
        if (chooseGameOption("Set bet") == 1) {
            betAmount = promptUserForBetAmount();
        }
        String menuDecision = null;
        Console.println("\nPlease wait while dealer is dealing cards...\n");
        blackJackDealer.deal(player);//, 2);
        blackJackDealer.deal(player);

        blackJackDealer.deal(blackJackDealer);//, 2);
        blackJackDealer.deal(blackJackDealer);
        Console.delay(3000);

        begin_decisions:
        while (!"leave".equals(menuDecision)) {
            Console.println("You view your new card(s)...\n\n");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Console.clear();
            Console.clear();
            Hand hand = player.getHand();
            Console.println(hand.toString());
            Console.println("\nYour card values equal " + hand.getHandSum() + ".");
            Console.println("Your hand is " + hand.getState() + ".");


            String playerState = player.getHand().getState();
            if ("BUST".equals(playerState)) {
                Console.println("BUST!");
                Console.println("You lose your bet.");
                Console.println("Your new balance is [%s]", player.getWallet());
                leaveTable(player);
//                break;


            } else if ("BLACKJACK".equals(playerState)) {
                Console.println("BLACKJACK!");
                Console.println("You WIN bet.");
                player.incrementWallet(betAmount * 2);
                Console.println("Player's new balance is [%s]", player.getWallet());
                leaveTable(player);
//                break;

            }// else {
               // continue begin_decisions;
            //}
            if (!playerStand) {
                menuDecision = Console.getStringInput("\n\nWhat would you like to do?\n[HIT] | [STAND] | [DOUBLE] DOWN");
                Console.println("Player has selected [ %s ]", menuDecision);
                switch (menuDecision.toUpperCase()) {
                    case "HIT":
                        blackJackDealer.deal(player);
                        break;

                    case "STAND":
                        playerStand = true;
                        break;

                }
            }
            Console.println("[INFO] DEALER HAND SUM: "+blackJackDealer.getHand().getHandSum());
            if (blackJackDealer.getHand().getHandSum() < 17) {
                blackJackDealer.deal(blackJackDealer);
            } else {
                dealerDone = true;
            }
            if (playerStand && dealerDone) {
                Integer dealerSum = blackJackDealer.getHand().getHandSum();
                Integer playerSum = player.getHand().getHandSum();
                if (dealerSum >= playerSum && dealerSum <= 21) {
                    Console.println("[INFO]  DEALER WON");
                    //dealerwin
                } else {
                    Console.println("[INFO] PLAYER WON");
                    player.incrementWallet(betAmount*2);
                    Console.println("You won your monies: $%.2f", betAmount*2);
                    //playerwin
                }
                break;
            }

        }
        leaveTable(player);


    }
    private void leaveTable(BlackJackPlayer player){
        Console.println("Would like to leave the game?");
        String option = Console.getStringInput("Yes, leave game.\nNo, start new game.");
        switch(option.toUpperCase()) {
            case "NO":
                BlackJackGame bjGame = new BlackJackGame(player);
                bjGame.displayBlackJackMenu();
                break;
            default:
                Casino casino = new Casino(player.getName(), player.getWallet());
                break;

        }
    }

    private static void showGameRules() {
        Console.clear();
        String rules = Rules.blackjack;
        Console.println(rules);
        Console.delay(6000);
    }
    public Integer chooseGameOption(String option) {
        Integer choice = UserDisplay.displayOptions(option, "Leave table");
        switch(choice) {
            case 1:
                // pass
                break;
            case 2:
                // leave table
                leaveTable(player);
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
            player.setBetAmount(betAmount);
        } while (!player.verifyValidBetAmount(betAmount));
        player.placeBet(betAmount);
        Console.println("You are wagering $%.2f", betAmount);
        Console.println("Your remaining balance is $%.2f\n", player.getWallet());
        return betAmount;
    }

//    public getWinner() {
//
//
//    }

}
