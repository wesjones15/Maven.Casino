package io.zipcoder.casino.casinotoolstest;

import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.DeckOfCards;
import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class DeckOfCardsTest {

    @Test
    public void createDeckOfCards_Test(){
        //Given
        DeckOfCards deckOfCards = new DeckOfCards();
        Stack<Card> newDeck;

        //When
        newDeck = deckOfCards.createDeckOfCards();
        Card expected = newDeck.peek();

        Assert.assertEquals(expected, newDeck.pop());
    }
}
