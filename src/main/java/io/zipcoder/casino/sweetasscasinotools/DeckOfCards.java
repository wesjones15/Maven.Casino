package io.zipcoder.casino.sweetasscasinotools;

import io.zipcoder.casino.sweetasscasinotools.Card;

import java.util.ArrayList;

public class DeckOfCards {
    private final String[] suites = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private final String[] faces = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private final Integer[] values = {2,3,4,5,6,7,8,9,10,11,12,13};
    private Card[] deck;
    private ArrayList<Card> currentDeck;

    public DeckOfCards() {
        this.deck = createDeckOfCards();
    }

    public Card[] createDeckOfCards() {
        Card[] deck = new Card[52];
        int index = 0;
        for(int i = 0; i < suites.length; i++) {
            for (int j = 0; j < faces.length; j++) {
                deck[index] = new Card(suites[i],faces[j],values[j]);
            }
        }
        return deck;
    }

    public ArrayList<Card> shuffleDeck(Card[] deck) {
        return null;
    }

    public Card drawCard(ArrayList<Card> currentDeck) {
        Card card = currentDeck.get(0);
        currentDeck.remove(0);
        return card;
    }

    public Card getCard() {
        return null;
    }

    public Card revealCard() {
        return null;
    }

}