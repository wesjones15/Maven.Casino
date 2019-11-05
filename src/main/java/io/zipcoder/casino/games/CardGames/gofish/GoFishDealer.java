package io.zipcoder.casino.games.CardGames.gofish;

import io.zipcoder.casino.sweetasscasinotools.Card;

import java.util.ArrayList;

public class GoFishDealer {
    private ArrayList<Card> hand;
    private int fourOfAKind = 0;

    public GoFishDealer() {
        this.hand = new ArrayList<Card>();
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

    public Card draw() {
        return null;
    }


    ////ADD CARDS TO HAND////
    public void pickUpHand(Card beingDealt){
        this.hand.add(beingDealt);
    }
    public int getFourOfAKind(){
        return this.fourOfAKind;
    }
    public String showHand(){
        String displayHand = "Cards in hand\n";
        for(Card each : hand){
            displayHand += each.toString() + "\n";
        }
        return displayHand;
    }

}
