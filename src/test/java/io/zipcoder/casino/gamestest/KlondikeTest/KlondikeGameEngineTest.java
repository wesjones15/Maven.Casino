package io.zipcoder.casino.gamestest.KlondikeTest;

import io.zipcoder.casino.games.DiceGames.klondike.KlondikeGame;
import io.zipcoder.casino.games.DiceGames.klondike.KlondikeGameEngine;
import io.zipcoder.casino.sweetasscasinotools.Dice;
import io.zipcoder.casino.sweetasscasinotools.Die;
import io.zipcoder.casino.userandplayer.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class KlondikeGameEngineTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void choiceFromKlondikeMenu() {

    }

    @Test
    public void executeActionChosen() {

    }

    @Test
    public void dealerDieRoll() {
    }


    @Test
    public void getWinner() {
        // Given
        Integer[] counts1 = {2, 1, 2, 1, 1};
        Integer[] counts2 = {1, 2, 2, 1, 1};
        Integer[] counts3 = {1, 2, 2, 2, 2};
        //KlondikeGame newGame = new KlondikeGame(new User("", 1, 1, 0.0));

        // When
        Boolean actual1 = KlondikeGame.isOnePair(counts1);
        Boolean actual2 = KlondikeGame.isOnePair(counts2);
        Boolean actual3 = KlondikeGame.isOnePair(counts3);


        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertFalse(actual3);

    }
}