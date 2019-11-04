package io.zipcoder.casino.gofish;

import io.zipcoder.casino.Card;
import java.util.ArrayList;
import java.util.Stack;

public class GoFishGame {

    private Stack<Card> deck;
    private Card card;

    public GoFishGame(Stack<Card> deck) {
        this.deck = deck;
    }


    public void passCardstoPlayer(){

    }

    public void checkFourOfAKind(ArrayList<Card> inHand) {

    }

    public void shuffle() {

    }

    public Stack<Card> getCard() {
        return deck;

    }



    //pulling methods from game interface


}
