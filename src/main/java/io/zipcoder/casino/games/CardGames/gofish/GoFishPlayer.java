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

    public GoFishPlayer(User user) {
        this.hand = new ArrayList<Card>();
    }
    public GoFishPlayer(){
        this.hand = new ArrayList<Card>();
    }

    // if card(s) are in  hand of this player
    public ArrayList<Card> passCard(Card requested) {

        ArrayList<Card> cardsToPass = new ArrayList<Card>();

        for(Card each : hand){
            if(each.getValue().equals(requested.getValue()))
                cardsToPass.add(each);
        }
        removingPassedCards(requested);

        return cardsToPass;
    }
    public void removingPassedCards(Card requested){
        Iterator<Card> temp = hand.iterator();

        while(temp.hasNext()){
            Card removeCard = temp.next();
            if(removeCard.getValue().equals(requested.getValue())){
                temp.remove();
            }
        }
    }
    public void draw(Stack<Card> deck) {
        this.hand.add(deck.pop());
        removeFourOfAKind();
    }

    //////ADD CARDS TO HAND////
    public void pickUpHand(Card beingDealt){
        this.hand.add(beingDealt);
    }

    //GETTERS
    public int getFourOfAKind(){
        return this.fourOfAKind;
    }
    public String showHand(){

        String displayHand = "Cards in hand\n";
        int counter = 1;
        for(Card each : hand){
             displayHand +=  counter + " : "+ each + "\n";
             counter++;
        }
        displayHand += "\nChoose a card to request:";
        return displayHand;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }

    ///GETTING CARDS AND REMOVING FOUR OF A KIND//
    //////////////////////////////////////////////
    public void receiveCards(ArrayList<Card> cards){
        hand.addAll(cards);
        removeFourOfAKind();
    }
    public Card getCard(Integer card){
        return hand.get(card-1);

    }
    public void removeFourOfAKind(){
        if(checkFour()){
            removingPassedCards(fourCard);
            fourOfAKind++;
        }
    }
    public boolean checkFour(){
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
