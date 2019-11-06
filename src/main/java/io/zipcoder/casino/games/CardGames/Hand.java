package io.zipcoder.casino.games.CardGames;

import io.zipcoder.casino.games.CardGames.blackjack.BlackJackPlayer;
import io.zipcoder.casino.sweetasscasinotools.Card;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> hand;


    public Hand(List<Card> listOfCards) {
        this.hand = listOfCards;
    }

    public Hand() {
        this(new ArrayList<>());
    }

    public void add(Card card) {
        hand.add(card);
    }

    public Integer getHandSum() {
        Integer sum = 0;
        for(Card card : hand) {
            Integer cardValue = card.getValue();
            sum += cardValue;
        }
        return sum;
    }

    public String getState() {
        Integer playerHandSum = getHandSum();
        if (playerHandSum == 21) {
            return "BLACKJACK";
        } else if (playerHandSum > 21) {
            return "BUST";
        } else {
            return "UNDER";
        }
    }

    @Override
    public String toString() {
        return "Hand{" + hand +'}';
    }
}
