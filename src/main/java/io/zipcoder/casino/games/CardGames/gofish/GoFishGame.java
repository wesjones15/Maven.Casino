package io.zipcoder.casino.games.CardGames.gofish;

import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.userandplayer.User;


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

        return "--> Go Fish Rules <--\n" +
                "   - Ask opponent for a card from the ones in your hand.\n" +
                "   - if opponent has cards, He must pass all the cards requested\n" +
                "   - If not, Draw a Card\n" +
                "   - Repeat\n" +
                "   - Game ends when a player reaches four stacks of four of a kind or \n" +
                "     there are no more cards in the deck\n" +
                "   - HAVE FUN!!\n\n";
    }

    public Integer getDeckSize(){
        return this.deck.size();
    }

}
