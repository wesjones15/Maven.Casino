package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.games.CardGames.Hand;
import io.zipcoder.casino.sweetasscasinotools.Deck;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.*;

public class BlackJackGame {
    private BlackJackDealer blackJackDealer;
    private BlackJackPlayer player;
    private Deck deck;


    public BlackJackGame(BlackJackDealer blackJackDealer, BlackJackPlayer player, Deck deck) {
        this.blackJackDealer = blackJackDealer;
        this.player = player;
        this.deck = deck;
    }

    public BlackJackGame(User user) {
        this(new BlackJackDealer(), new BlackJackPlayer(user), new Deck());
    }

    public BlackJackGame(String name, Double wallet) {
        this.player = new BlackJackPlayer(name, wallet);
        this.blackJackDealer = new BlackJackDealer();
        this.deck = new Deck();
    }

    public void displayBlackJackMenu() {
        String choice = Console.getStringInput("\n\n\n\tWelcome to\n" + Art.bjSign + "\n\n" +
                "\t\tType Your [SELECTION]\n\n" +
                "\t\t\t[BET] To Begin\n" + "\t\t\t[VIEW] Rules\n" +
                "\t\t\t[LEAVE] Table\n" + "_________________________________________________");
        menuChoice(choice);
        //string escape
    }
    public void menuChoice(String choice) {
        switch (choice.toUpperCase()) {
            case "BET":
                run();
                break;
            case "VIEW":
                BlackJackGame.showGameRules();
                displayBlackJackMenu();
            case "LEAVE":
                leaveTable(player);
                break;
            default:
                Console.println("Invalid input - try again!\n\n");
                displayBlackJackMenu();
                break;
        }
    }
    public void run() {
        Boolean dealerDone;
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
            Console.delay(2700);
            Console.clear();
            Console.clear();
            Hand hand = player.getHand();
            Console.println(hand.toString());
            Console.println("\nYour card values equal " + hand.getHandSum() + ".");
            Console.println("Your hand is " + hand.getState() + ".\n");


            String playerState = player.getHand().getState();
            if ("BUST".equals(playerState)) {
                Console.println("BUST!");
                Console.println("You lose your bet.");
                Console.println("Your new balance is [%s]\n", player.getWallet() + ".");
                leaveTable(player);

            } else if ("BLACKJACK".equals(playerState)) {
                Console.println("BLACKJACK!");
                Console.println("You WIN your bet.");
                player.incrementWallet(betAmount * 2);
                Console.println("Player's new balance is [%s]\n", player.getWallet() + ".");
                leaveTable(player);
            }

            if (!playerStand) {
                menuDecision = Console.getStringInput("\n\nWhat would you like to do?\n[HIT] OR [STAND]");
                Console.println("\nPlayer has selected [ %s ]\n", menuDecision);
                switch (menuDecision.toUpperCase()) {
                    case "HIT":
                        blackJackDealer.deal(player);
                        break;
                    case "STAND":
                        playerStand = true;
                        break;
                    default:
                        Console.println("Invalid input, try again!");
                }
            }
//            Console.println("\nDealer's current sum is "+blackJackDealer.getHand().getHandSum() + ".");
            dealerDone = checkDealerHand();

            if (playerStand && dealerDone) {
                Console.println("Dealer hits...");
                Console.delay(2000);
                Console.println("\nDealer's current sum is "+blackJackDealer.getHand().getHandSum() + ".\n\n");
                Console.delay(2000);
                playerStandGameEnd(betAmount);
                break;
            }
        }
        leaveTable(player);
    }

    public String playerStandGameEnd(Double betAmount) {
        Integer dealerSum = blackJackDealer.getHand().getHandSum();
        Integer playerSum = player.getHand().getHandSum();
        StringBuilder message = new StringBuilder();
        if (dealerSum >= playerSum && dealerSum <= 21) {
            message.append("\nDealer Won ┻━┻ ︵ ლ(ಠ益ಠლ) with a final total of: " + blackJackDealer.getHand().getHandSum() + "\nBye Bye Monies.");
        } else {
            message.append("YOU WON! ˚✧₊⁎( ˘ω˘ )⁎⁺˳✧༚\n");
            player.incrementWallet(betAmount*2);
            message.append(String.format("You won some monies: $%.2f", betAmount*2));
        }
        Console.println(message.toString());
        return message.toString();
    }

    public Boolean checkDealerHand() {
        Boolean dealerDone = false;
        if (blackJackDealer.getHand().getHandSum() < 17) {
            blackJackDealer.deal(blackJackDealer);
        } else {
            dealerDone = true;
        }
        return dealerDone;
    }

    private void leaveTable(BlackJackPlayer player){
        Console.println("\n\nWould like to leave the game?");
        String option = Console.getStringInput("Yes, leave game.\nNo, start new game.");
        switch(option.toUpperCase()) {
            case "NO":
                BlackJackGame bjGame = new BlackJackGame(player.getName(), player.getWallet());
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
            case 1: // pass
                break;
            case 2:
                leaveTable(player);
                break;
            default:
                Console.println("Invalid Option - try again");
        }
        return choice;
    }

    public Double promptUserForBetAmount() {
        Console.println("Receive 2X your wager if you win! ╰( ･ ᗜ ･ )╯");
        Double betAmount = 0.0;
        do {
            betAmount = Console.getDoubleInput("Enter your bet please: ");
            player.setBetAmount(betAmount);
        } while (!player.verifyValidBetAmount(betAmount));
        player.placeBet(betAmount);
        Console.println("You are wagering $%.2f", betAmount);
        Console.println("Your remaining balance is $%.2f\n", player.getWallet());
        return betAmount;
    }

}
