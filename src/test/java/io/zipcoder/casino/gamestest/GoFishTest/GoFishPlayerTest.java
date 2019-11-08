package io.zipcoder.casino.gamestest.GoFishTest;

import io.zipcoder.casino.games.CardGames.gofish.GoFishPlayer;
import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.DeckOfCards;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class GoFishPlayerTest {


    @Test
    public void passCardTest(){
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        DeckOfCards deckOfCards = new DeckOfCards();
        Stack<Card> deck = deckOfCards.createDeckOfCards();
        Card expected = deck.pop();

        //when
        goFishPlayer.pickUpHand(expected);
        goFishPlayer.pickUpHand(deck.pop());
        goFishPlayer.pickUpHand(deck.pop());
        ArrayList<Card> passedTo = new ArrayList<Card>();
        passedTo.addAll(goFishPlayer.passCard(expected));


        //then
        Assert.assertTrue(passedTo.contains(expected));

    }

    @Test
    public void removingPassedCards_Test(){
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        DeckOfCards deckOfCards = new DeckOfCards();
        Stack<Card> deck = deckOfCards.createDeckOfCards();
        Card expected = deck.pop();

        //When
        goFishPlayer.pickUpHand(expected);
        for(int i = 0 ; i < 3; i++)
            goFishPlayer.draw(deck);

        goFishPlayer.removingPassedCards(expected);

        //then
        Assert.assertFalse(goFishPlayer.getHand().contains(expected));

    }
    @Test
    public void removingPassedCards_Test2(){
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        DeckOfCards deckOfCards = new DeckOfCards();
        Stack<Card> deck = deckOfCards.createDeckOfCards();
        Card card = deck.pop();

        //When
        goFishPlayer.pickUpHand(card);
        goFishPlayer.setHand(deck);
        Integer expected = 4;
        Integer actual = goFishPlayer.removingPassedCards(card);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void draw_and_PickUpHand_Test(){
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        DeckOfCards deckOfCards = new DeckOfCards();
        Stack<Card> deck = deckOfCards.createDeckOfCards();
        Integer expected = 2;


        //When
        goFishPlayer.draw(deck);
        goFishPlayer.pickUpHand(deck.pop());

        //then
        Assert.assertEquals(expected, goFishPlayer.sizeOfHand());
        Assert.assertEquals(expected, goFishPlayer.sizeOfHand());

    }
    @Test
    public void getHandTest(){
        //given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        DeckOfCards deckOfCards = new DeckOfCards();
        Stack<Card> deck = deckOfCards.createDeckOfCards();

        //when
        for(int i = 0; i < 7; i++)
            goFishPlayer.draw(deck);

        ArrayList<Card> expected = goFishPlayer.getHand();

        //then
        Assert.assertNotNull(goFishPlayer.getHand());
        Assert.assertEquals(expected, goFishPlayer.getHand());
    }

    @Test
    public void getFourOfAKind_Test(){
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        DeckOfCards deckOfCards = new DeckOfCards();
        Stack<Card> deck = deckOfCards.createDeckOfCards();
        int expected = 1;

        //When
        goFishPlayer.setHand(deck);
        Console.println(" " + goFishPlayer.sizeOfHand());
        goFishPlayer.removeFourOfAKind();

        //Then
        Assert.assertEquals(expected, goFishPlayer.getFourOfAKind());
    }

    @Test
    public void sizeOfHandTest(){
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        DeckOfCards deckOfCards = new DeckOfCards();
        Stack<Card> deck = deckOfCards.createDeckOfCards();
        Card card = deck.pop();
        Integer expected = 2;
        Integer expected2 = 3;

        //When
        goFishPlayer.pickUpHand(card);
        goFishPlayer.draw(deck);

        //Then
        Assert.assertEquals(expected, goFishPlayer.sizeOfHand());

        //When
        goFishPlayer.draw(deck);

        //Then
        Assert.assertEquals(expected2, goFishPlayer.sizeOfHand());

    }

    @Test
    public void receiveCards_Test(){
        //Given
        GoFishPlayer goFishPlayer = new GoFishPlayer();
        DeckOfCards deckOfCards = new DeckOfCards();
        Stack<Card> deck = deckOfCards.createDeckOfCards();
        ArrayList<Card> receivedCards = new ArrayList<Card>();

        //When
        for(int i = 0; i < 3; i++)
            receivedCards.add(deck.pop());
        goFishPlayer.receiveCards(receivedCards);

        Integer expected = 3;

        Assert.assertEquals(expected, goFishPlayer.sizeOfHand());
    }

}
