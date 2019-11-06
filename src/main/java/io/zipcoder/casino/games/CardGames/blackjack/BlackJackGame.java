package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.sweetasscasinotools.Deck;
import io.zipcoder.casino.games.CardGames.Hand;
import io.zipcoder.casino.utilities.Console;

import java.util.Collections;

public class BlackJackGame {
    private BlackJackDealer dealer;
    private BlackJackPlayer player;

    public BlackJackGame(BlackJackPlayer blackJackPlayer, BlackJackDealer blackJackDealer) {
        this.dealer = blackJackDealer;
        this.player = blackJackPlayer;
    }


    public void run() {
        String menuDecision = null;
        Console.println("Welcome to a new game of BlackJack!");
        Console.println("Dealer is dealing cards.");
        dealer.deal(player);
        dealer.deal(player);

        begin_decisions:
        while (!"leave".equals(menuDecision)) {
            Console.println("From here you can select any of the following options:");
            menuDecision = Console.getStringInput("[VIEW] hand, [HIT], [STAND]");
            Console.println("Player has selected [ %s ]", menuDecision);
            Hand hand = player.getHand();

            switch (menuDecision.toUpperCase()) {
                case "VIEW":
                    Console.println("Displaying hand of player");
                    Console.println(hand.toString());
                    break;

                case "HIT":
                    dealer.deal(player);
                    break;

                case "STAND":

                    String playerState = player.getHand().getState();
                    if("BUSS".equals(playerState)) {
                        Console.println("Player BUST!");
                        Console.println("Player loses bet.");
                        Console.println("Player's balance was [%s]", player.getBalance());
                        player.loseBet();
                        Console.println("Player's new balance is [%s]", player.getBalance());

                    } else if("BLACKJACK".equals(playerState)) {
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
