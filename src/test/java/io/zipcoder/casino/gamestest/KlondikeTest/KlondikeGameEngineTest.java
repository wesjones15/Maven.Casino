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
    public void executeActionChosenTest() {
       /* String expected1 = "Start Klondike Game";
        String expected2 = "Display Klondike Rules";
        String expected3 = "Leave Game";
        String expected4 = "Re-route player to main Klondike menu";

        KlondikeGameEngine kge = new KlondikeGameEngine(new User("", 20, 1, 0.0);

        String actual1 = kge.executeActionChosen(1);
        String actual2 = kge.executeActionChosen(2);
        String actual3 = kge.executeActionChosen(3);
        String actual4 = kge.executeActionChosen(4);



        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
        Assert.assertEquals(expected4, actual4);
*/

    }

    @Test
    public void chooseGameOptionTest() {

    }

    @Test
    public void getWinnerTest() {
        // Given
        Integer[] counts1 = {2, 1, 2, 1, 1};
        Integer[] counts2 = {1, 2, 2, 1, 1};
        Integer[] counts3 = {1, 2, 2, 2, 2};

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