package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.games.CardGames.Hand;
import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.Deck;
import io.zipcoder.casino.utilities.Console;

import java.util.Collections;

public class BlackJackDealer extends BlackJackPlayer {
    Deck deck;// = new Deck();
    private Hand hand;

    public BlackJackDealer() {
        super("Dealer", 40000000000.0);
        this.hand = new Hand();
        this.deck = new Deck();
        deck.shuffle();
    }

    public void deal(BlackJackPlayer player, int numberOfCards) {
        for (int currentIteration = 0; currentIteration < numberOfCards; currentIteration++) {
            deal(player);
        }
    }

    public void deal(BlackJackPlayer player){//}, Deck deck) {
        Card card = deck.removeTopCard();
        player.acceptCard(card);
    }

}

