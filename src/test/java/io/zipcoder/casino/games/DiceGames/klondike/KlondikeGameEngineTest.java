package io.zipcoder.casino.games.DiceGames.klondike;

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
    public void playerDieRoll() {
    }

    @Test
    public void getNumberOfOccurrences() {
        // Given
        Integer[] faceValues = {2, 4, 3, 3, 6};
        Integer value = 3;
        KlondikeGameEngine newGame = new KlondikeGameEngine(new User("", 1, 1, 0.0));
        Integer expected = 2;
        // When
        Integer actual = newGame.getNumberOfOccurrences(faceValues, value);
        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void faceValueCount() {
        // Given
        Integer[] faceValues = {2, 4, 1, 2, 5};
        KlondikeGameEngine newGame = new KlondikeGameEngine(new User("", 1, 1, 0.0));
        //Integer[] expected = {0, 1, 2, 0, 1, 1};
        Integer[] expected2 = {2, 1, 1, 2, 1};
        // When
        Integer[] actual = newGame.faceValueCount(faceValues);
        System.out.println(Arrays.toString(actual));
        // Then
        //Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual);
    }
}