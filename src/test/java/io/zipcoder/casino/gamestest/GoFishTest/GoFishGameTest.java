package io.zipcoder.casino.gamestest.GoFishTest;

import io.zipcoder.casino.games.CardGames.gofish.GoFishGame;
import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.sweetasscasinotools.DeckOfCards;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

public class GoFishGameTest {
    DeckOfCards deck = new DeckOfCards();

    @Test
    public void GoFishGameConstructorTest(){
        //Given
        Stack<Card> goFishDeck;
        goFishDeck = deck.createDeckOfCards();

        //When

        GoFishGame goFishGame = new GoFishGame(goFishDeck);

        //Then
        Assert.assertEquals(goFishDeck, goFishGame.getDeck());

    }

    @Test
    public void dealHand_Test(){
        //Given
        GoFishGame goFishGame = new GoFishGame(deck.createDeckOfCards());
        ArrayList<Card> hand = new ArrayList<>();

        //when
        hand.add(goFishGame.DealHands());

        //Then
        Assert.assertNotNull(hand);
    }

    @Test
    public void checkHand_Test(){
        //Given
        GoFishGame goFishGame = new GoFishGame(deck.createDeckOfCards());
        ArrayList<Card> hand = new ArrayList<>();
        Card checkRequestedCard = goFishGame.DealHands();

        //When
        hand.add(checkRequestedCard);
        for(int i = 0; i < 7; i++)
            hand.add(goFishGame.DealHands());

        //Then
        Assert.assertTrue(goFishGame.checkHand(hand, checkRequestedCard));
    }

    @Test
    public void getDeck_Test(){
        //Given
        GoFishGame goFishGame = new GoFishGame(deck.createDeckOfCards());

        //Then
        Assert.assertNotNull(goFishGame.getDeck());
    }

    @Test
    public void getDeckSize_Test(){
        //Given
        GoFishGame goFishGame = new GoFishGame(deck.createDeckOfCards());
        ArrayList<Card> hand = new ArrayList<>();
        Integer removing = 2;
        Integer expected = (52 - removing);

        //When
        for(int i = 0; i < removing; i++)
            hand.add(goFishGame.DealHands());

        //Then
        Assert.assertEquals(expected, goFishGame.getDeckSize());
    }
}
