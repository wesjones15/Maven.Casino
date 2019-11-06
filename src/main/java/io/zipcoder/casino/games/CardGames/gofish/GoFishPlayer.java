package io.zipcoder.casino.games.CardGames.gofish;

import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.userandplayer.User;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class GoFishPlayer {

    private ArrayList<Card> hand;
    private int fourOfAKind = 0;
    private Card fourCard;

     GoFishPlayer(User user) {
        this.hand = new ArrayList<Card>();
    }
     GoFishPlayer(){
        this.hand = new ArrayList<Card>();
    }

    // if card(s) are in  hand of this player
     ArrayList<Card> passCard(Card requested) {

        ArrayList<Card> cardsToPass = new ArrayList<Card>();

        for(Card each : hand){
            if(each.getValue().equals(requested.getValue()))
                cardsToPass.add(each);
        }
        removingPassedCards(requested);

        return cardsToPass;
    }
     void removingPassedCards(Card requested){
        Iterator<Card> temp = hand.iterator();

        while(temp.hasNext()){
            Card removeCard = temp.next();
            if(removeCard.getValue().equals(requested.getValue())){
                temp.remove();
            }
        }
    }
     void draw(Stack<Card> deck) {
        this.hand.add(deck.pop());
        removeFourOfAKind();
    }

    //////ADD CARDS TO HAND////
     void pickUpHand(Card beingDealt){
        this.hand.add(beingDealt);
    }

    //GETTERS
     int getFourOfAKind(){
        return this.fourOfAKind;
    }
     String showHand(){

        String displayHand = "Cards in hand\n";
        int counter = 1;
        for(Card each : hand){
             displayHand +=  counter + " : "+ each + "\n";
             counter++;
        }
        displayHand += "\nChoose a card to request:";
        return displayHand;
    }
     ArrayList<Card> getHand() {
        return hand;
    }

    ///GETTING CARDS AND REMOVING FOUR OF A KIND//
    //////////////////////////////////////////////
     void receiveCards(ArrayList<Card> cards){
        hand.addAll(cards);
        removeFourOfAKind();
    }
     Card getCard(Integer card){
        return hand.get(card-1);

    }
     void removeFourOfAKind(){
        if(checkFour()){
            removingPassedCards(fourCard);
            fourOfAKind++;
        }
    }
     boolean checkFour(){
        int max = 1;
        int current;
        Card popular = hand.get(0);
        Card temp;
        for(Card each : hand){
            temp = each;
            current = 0;

            for(Card other : hand){
                if(temp.getValue().equals(other.getValue())){
                    current++;
                }
            }
            if(current > max){
                popular = temp;
                max = current;
            }
        }
        if(max == 4){
            this.fourCard = popular;
            return true;
        }
        return false;
    }


}
