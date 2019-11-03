package io.zipcoder.casino.gofish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.User;

import java.util.ArrayList;
import java.util.Stack;

public class GoFishPlayer {
    private ArrayList<Card> hand;
    private int fourOfAKind;
    private Double wallet;


    public GoFishPlayer(ArrayList<Card> hand, User user) {

        this.hand = hand;
        this.wallet = user.getWallet();
    }


    public Boolean askCard(Card requestedCard, GoFishPlayer player) {
        return null;
    }

    // if card(s) are in  hand of this player
    public ArrayList<Card> passCard(Card cardInHandToBePassed) {

        ArrayList<Card> cardsToPass = new ArrayList<Card>();

        for(Card each : hand){
            if(each == cardInHandToBePassed){
                cardsToPass.add(each);
            }
        }
        return cardsToPass;
    }

    public Boolean checkHand() {
        return null;
    }

    public void draw(Stack<Card> deck) {
        this.hand.add(deck.pop());
    }

    public Boolean checkFourOfAKind() {

      return null;
    }


}
