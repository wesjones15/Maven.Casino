package io.zipcoder.casino.games.CardGames.blackjack;


//public class BlackJackGame {
//    private Stack<Card> deck;
//    private Card card;
//
//
//    public BlackJackGame(Stack<Card> deck) {this.deck = deck;
//    }
//    public Card DealHands(){
//        if(deck.size() == 0){
//            System.out.println("Deck Empty!");
//        }
//        return deck.pop();
//    }
//
//    public static void showGameRules() {
//    }
//
//    public Stack<Card> getDeck() {
//        return deck;
//    }
//
//    public void shuffle() {
//
//    }
//
//    public String playerMove() {
//        return null;
//    }
//
//    public String dealerMove() {
//        return null;
//    }
//
//    public Boolean getWinner() {
//        return null;
//    }
//
//    public Boolean getLoser() {
//        return null;
//    }
//
//
//
//    //pulling methods from gambling game and game interface


import io.zipcoder.casino.games.CardGames.Hand;
import io.zipcoder.casino.sweetasscasinotools.Deck;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.Casino;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.UserDisplay;

public class BlackJackGame {
    private BlackJackDealer blackJackDealer;
    private BlackJackPlayer player;
    private Deck deck;


    public BlackJackGame(User user){
        this.blackJackDealer = new BlackJackDealer();
        this.player = new BlackJackPlayer(user.getName(), user.getWallet());
        this.deck = new Deck();
        displayBlackJackMenu();
    }
    public BlackJackGame(BlackJackPlayer player) {
        this.blackJackDealer = new BlackJackDealer();
//        this.blackJackPlayer = player;
        this.player = new BlackJackPlayer(player.getName(), player.getWallet());
        displayBlackJackMenu();
    }
    //BlackJack Menu & Choices//5
//    public void displayBlackJackMenu() {
//        menuChoice(Console.getIntegerInput( " ___________________________\r\n|\tWelcome to BlackJack!\t|\r\n|\t\t\t\t\t\t\t|\r\n|\t\t1. Deal Hand\t\t|\r\n|\t\t2. View Rules\t\t|\r\n|\t\t3. Leave Table\t\t|\r\n|___________________________|"));
//     //string escape
//    }
//Console.println(" ___________________________\r\n|\tWelcome to BlackJack!\t|\r\n|\t\t\t\t\t\t\t|\r\n|\t\t[DEAL] Hand\t\t|\r\n|\t\t[VIEW] Rules\t\t|\r\n|\t\t[LEAVE] Table\t\t|\r\n|___________________________");
//    private void menuChoice(Integer choice) {
//        switch(choice){
//            case 1:
//                runGame();
//                break;
//            case 2:
//                BlackJackGame.showGameRules();
//                displayBlackJackMenu();
//            case 3:
//                leaveTable();
//                break;
//            default:
//                Console.println("Invalid input, try again!");
//        }
//    }
    //BlackJack Menu &Choices

    public void displayBlackJackMenu() {
        menuChoice(Console.getStringInput(" ___________________________\r\n|\tWelcome to BlackJack!\t|\r\n|\t\t\t\t\t\t\t|\r\n|\t\t[DEAL] Hand\t\t\t|\r\n|\t\t[VIEW] Rules\t\t|\r\n|\t\t[LEAVE] Table\t\t|\r\n|___________________________|"));
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
        Double betAmount = 0.00;
        if (chooseGameOption("Set bet") == 1) {
            betAmount = promptUserForBetAmount();
        }
        String menuDecision = null;
        Console.println("\nPlease wait while dealer is dealing cards...\n");
        blackJackDealer.deal(player);
        blackJackDealer.deal(player);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
//            Console.println("\nFrom here you can select any of the following options:");


            String playerState = player.getHand().getState();
            if ("BUST".equals(playerState)) {
                Console.println("Player BUST!");
                Console.println("You lose your bet.");
                Console.println("Your balance was [%s]", player.getWallet());
//                        player.loseBet();
                Console.println("Player's new balance is [%s]", player.getWallet());
                leaveTable(player);


            } else if ("BLACKJACK".equals(playerState)) {
                Console.println("Player BLACKJACK!");
                Console.println("Player WINS bet.");
                Console.println("Player's balance was [%s]", player.getWallet());
//                        player.winBet();
                player.incrementWallet(betAmount*2); //TODO make winBet method in player?
                Console.println("Player's new balance is [%s]", player.getWallet());
                leaveTable(player);
            }// else {
               // continue begin_decisions;
            //}
            menuDecision = Console.getStringInput("\n\nWhat would you like to do?\n[HIT] OR [STAND]");
            Console.println("Player has selected [ %s ]", menuDecision);
            switch (menuDecision.toUpperCase()) {
                case "HIT":
                    blackJackDealer.deal(player);
                    break;

                case "STAND":
                    break;
            }
        }

    }
    private void leaveTable(BlackJackPlayer player){
        Console.println("Would like to leave the game?");
        String option = Console.getStringInput("Yes, leave game.\nNo, start new game.");
        switch(option.toUpperCase()) {
            case "NO":
                BlackJackGame bjGame = new BlackJackGame(player);
                break;
            default:
                Casino casino = new Casino(player.getName(), player.getWallet());
                break;

        }
    }

    private static void showGameRules() {

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
}
