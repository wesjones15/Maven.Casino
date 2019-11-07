package io.zipcoder.casino.games.CardGames.gofish;

import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.Rules;


import java.util.ArrayList;
import java.util.Stack;

public class GoFishGame {

    private Stack<Card> deck;

    public GoFishGame(Stack<Card> deck) {
        this.deck = deck;
    }

    public Card DealHands(){
        if(deck.size() == 0){
            System.out.println("Deck Empty!");
        }
        return deck.pop();
    }

    public Boolean checkHand(ArrayList<Card> hand, Card requested) {
        for(Card each: hand){
            if(requested.getValue().equals(each.getValue())){
                return true;
            }
        }
        return false;
    }
    public Stack<Card> getDeck() {
        return deck;
    }

    ///DISPLAY GAME RULES///
    ////////////////////////
    public String gameRules(){

        return Rules.goFish;
    }

    public Integer getDeckSize(){
        return this.deck.size();
    }

}
