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
import io.zipcoder.casino.utilities.Console;

public class BlackJackGame {
    private BlackJackDealer dealer;
    private BlackJackPlayer player;

    public BlackJackGame(BlackJackPlayer blackJackPlayer, BlackJackDealer blackJackDealer) {
        this.dealer = blackJackDealer;
        this.player = blackJackPlayer;
    }


    public void run() {
        String menuDecision = null;
        Console.println("Welcome to a new game of BlackJack!\n\n");
        Console.println("Please wait while dealer is dealing cards...");
        dealer.deal(player);
        dealer.deal(player);

        begin_decisions:
        while (!"leave".equals(menuDecision)) {
            Console.println("Player views their cards...\n\n");
            Hand hand = player.getHand();
            Console.println(hand.toString());
            Console.println("\nPlayer's card value equal " + hand.getHandSum());
            Console.println("\nFrom here you can select any of the following options:");
            menuDecision = Console.getStringInput("[HIT] OR [STAND]");
            Console.println("Player has selected [ %s ]", menuDecision);

            switch (menuDecision.toUpperCase()) {
                case "VIEW":
                    Console.println("Displaying hand of player");

                    break;

                case "HIT":
                    dealer.deal(player);
                    break;

                case "STAND":

                    String playerState = player.getHand().getState();
                    if ("BUST".equals(playerState)) {
                        Console.println("Player BUST!");
                        Console.println("Player loses bet.");
                        Console.println("Player's balance was [%s]", player.getBalance());
                        player.loseBet();
                        Console.println("Player's new balance is [%s]", player.getBalance());

                    } else if ("BLACKJACK".equals(playerState)) {
                        Console.println("Player BLACKJACK!");
                        Console.println("Player WINS bet.");
                        Console.println("Player's balance was [%s]", player.getBalance());
                        player.winBet();
                        Console.println("Player's new balance is [%s]", player.getBalance());
                    } else {
                        continue begin_decisions;
                    }
                    break;
            }
        }
    }
}
