package io.zipcoder.casino.games.CardGames.gofish;

import io.zipcoder.casino.sweetasscasinotools.Card;

public class GoFishDealer {
    private Card[] hand;
    private int fourOfAKind = 0;

    public GoFishDealer() {
    }

    public Card deal() {
        return null;
    }

    public Boolean askCard(Card requestedCard, GoFishPlayer player) {
        return null;
    }

    // if card(s) are in  hand of this player
    public void passCard(Card cardInHandToBePassed) {

    }

    public Boolean checkHand() {
        return null;
    }

    public Card draw() {
        return null;
    }

    public void checkFourOfAKind(Card[] hand) {

    }
    public int getFourOfAKind(){
        return this.fourOfAKind;
    }

}
