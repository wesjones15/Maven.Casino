package io.zipcoder.casino.gofish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.User;

import java.util.ArrayList;
import java.util.Stack;

public class GoFishPlayer {
    private ArrayList<Card> hand;
    private int fourOfAKind = 0;
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

    public Boolean checkHand(Card requested) {
        for(Card each: hand){
            if(requested == each){
                return true;
            }
        }
        return false;
    }

    public void draw(Stack<Card> deck) {
        this.hand.add(deck.pop());
    }
    public void pickUpHand(Card beingDealt){
        this.hand.add(beingDealt);
    }

    //GETTERS
    public int getFourOfAKind(){
        return this.fourOfAKind;
    }

    public String showHand(){
        String displayHand = "Cards in hand\n";
        for(Card each : hand){
            displayHand += each + "\n";
        }
        return displayHand;
    }





}
