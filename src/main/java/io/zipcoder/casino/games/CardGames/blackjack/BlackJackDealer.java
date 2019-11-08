package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.Deck;


public class BlackJackDealer extends BlackJackPlayer {
    private Deck deck;

    public BlackJackDealer() {
        super("Dealer", null);
        this.deck = new Deck();
        deck.shuffle();
    }


    public void deal(BlackJackPlayer player, Card card) {
        player.acceptCard(card);
    }
    public void deal(BlackJackPlayer player){
        deal(player, deck.removeTopCard());
    }
}

