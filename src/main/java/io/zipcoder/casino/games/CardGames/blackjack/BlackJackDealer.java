package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.games.CardGames.Hand;
import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.Deck;


public class BlackJackDealer extends BlackJackPlayer {
    Deck deck;
    private Hand hand;

    public BlackJackDealer() {
        super("Dealer", 40000000000.0);
        this.hand = new Hand();
        this.deck = new Deck();
        deck.shuffle();
    }

    public void deal(BlackJackPlayer player){
        Card card = deck.removeTopCard();
        player.acceptCard(card);
    }

}

