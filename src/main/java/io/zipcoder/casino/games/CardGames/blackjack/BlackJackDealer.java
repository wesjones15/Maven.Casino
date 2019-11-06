package io.zipcoder.casino.games.CardGames.blackjack;

//public class BlackJackDealer{
//    private Card[] hand;

//    public Card getCard() {
//        return null;
//    }
//
//    public int get21() { return 0;
//    }
    /*//while Hand < 16
    hit()
    //while Hand > 16 && hand < 21
    hit() || stay()
    //if hand == Player (Win)
//if hand > Player &&  hand < 21 (Win)
//if hand < Player (lose)
//if  hand > 21
    bust(); return lose;
//if hand == 21 (win)*/
//}

import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.Deck;
import io.zipcoder.casino.utilities.Console;

import java.util.Collections;

public class BlackJackDealer extends BlackJackPlayer {
    Deck deck = new Deck();

    public BlackJackDealer() {
        super(null);
        deck.shuffle();
    }

    public void deal(BlackJackPlayer player, int numberOfCards) {
        for (int currentIteration = 0; currentIteration < numberOfCards; currentIteration++) {
            deal(player, numberOfCards);
        }
    }

    public void deal(BlackJackPlayer player) {
        Console.println("The dealer hands a card to player");
        Card card = deck.removeTopCard();
        player.acceptCard(card);
    }
}

