package io.zipcoder.casino.games.CardGames;

import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.userandplayer.User;

public class CardPlayer {
    protected final User user;
    private Hand hand;

    public CardPlayer(User user) {
        this.hand = new Hand();
        this.user = user;
    }

    public Hand getHand() {
        return hand;
    }

    public void acceptCard(Card card) {
        hand.add(card);
    }
}
