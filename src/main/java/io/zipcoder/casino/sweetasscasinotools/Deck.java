package io.zipcoder.casino.sweetasscasinotools;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    private Stack<Card> stack;
    private final String[] suites = {"♧", "♢", "♡", "♤"};
    private final String[] faces = {"Ace of", "Two of", "Three of", "Four of", "Five of", "Six of", "Seven of", "Eight of", "Nine of", "Ten of", "Jack of", "Queen of", "King of"};
    private final Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 10};

    public Deck() {
        this.stack = new Stack<Card>();
        for (int i = 0; i < suites.length; i++) {
            for (int j = 0; j < faces.length; j++) {
                stack.push(new Card(suites[i], faces[j], values[j]));
            }
        }
    }

    public Card removeTopCard() {
        return stack.pop();
    }

//    public Card peek() {
//        return stack.peek();
//    }
//
//    public void add(Card card) {
//        stack.push(card);
//    }
//
//    public Boolean isEmpty() {
//        return stack.isEmpty();
//    }

    public void shuffle() {
        Collections.shuffle(stack);
    }

//    public Integer getDeckSize() {
//        return stack.size();
//    }

    @Override
    public String toString() {
        return "Deck{" + stack + '}';
    }
}
