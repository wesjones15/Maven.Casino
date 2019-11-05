package io.zipcoder.casino.sweetasscasinotools;

import io.zipcoder.casino.sweetasscasinotools.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DeckOfCards {
    private final String[] suites = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private final String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private final Integer[] values = {2,3,4,5,6,7,8,9,10,11,12,13,14};
    private Stack<Card> deck;
    //private ArrayList<Card> currentDeck;

    public DeckOfCards() {
        this.deck = createDeckOfCards();
    }

    public Stack<Card> createDeckOfCards() {
        Stack<Card> deck = new Stack<Card>();

        int index = 0;
        for(int i = 0; i < suites.length; i++) {
            for (int j = 0; j < faces.length; j++) {
                deck.push(new Card(suites[i],faces[j],values[j]));
            }
        }
        return shuffleDeck(deck);
    }

    public Stack<Card> shuffleDeck(Stack<Card> deck) {
        for(int i = 0; i < 2; i++)
            Collections.shuffle(deck);
        return deck;
    }

//    public Card drawCard(ArrayList<Card> currentDeck) {
//        Card card = currentDeck.get(0);
//        currentDeck.remove(0);
//        return card;
//    }

//    public Card getCard() {
//        return null;
//    }
//
//    public Card revealCard() {
//        return null;
//    }

}