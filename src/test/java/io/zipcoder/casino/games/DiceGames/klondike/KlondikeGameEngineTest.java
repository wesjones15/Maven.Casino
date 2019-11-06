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

    @Test
    public void isFiveOfAKind() {
        // Given
        Integer[] faceValues = {2, 2, 2, 2, 2};
        Integer[] counts = {5, 5, 5, 5, 5};
        KlondikeGameEngine newGame = new KlondikeGameEngine(new User("", 1, 1, 0.0));

        // When
        //Boolean actual1 = newGame.isFiveOfAKind(newGame.faceValueCount(faceValues));
        Boolean actual = newGame.isFiveOfAKind(counts);
        // Then
        Assert.assertTrue(actual);
        //Assert.assertTrue(actual1);

    }

    @Test
    public void isFourOfAKind() {
        // Given
        Integer[] counts1 = {4, 4, 4, 4, 1};
        Integer[] counts2 = {1, 4, 4, 4, 4};
        Integer[] counts3 = {4, 1, 4, 4, 4};
        Integer[] counts4 = {4, 4, 1, 4, 4};
        Integer[] counts5 = {4, 4, 4, 1, 4};


        KlondikeGameEngine newGame = new KlondikeGameEngine(new User("", 1, 1, 0.0));

        // When
        //Boolean actual = newGame.isFourOfAKind(newGame.faceValueCount(faceValues));
        Boolean actual1 = newGame.isFourOfAKind(counts1);
        Boolean actual2 = newGame.isFourOfAKind(counts2);
        Boolean actual3 = newGame.isFourOfAKind(counts3);
        Boolean actual4 = newGame.isFourOfAKind(counts4);
        Boolean actual5 = newGame.isFourOfAKind(counts5);

        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertTrue(actual3);
        Assert.assertTrue(actual4);
        Assert.assertTrue(actual5);
    }

    @Test
    public void isFullHouse() {
        // Given
        Integer[] counts1 = {3, 3, 3, 2, 2};
        Integer[] counts2 = {2, 3, 3, 3, 2};
        Integer[] counts3 = {1, 1, 1, 2, 2};

        KlondikeGameEngine newGame = new KlondikeGameEngine(new User("", 1, 1, 0.0));

        // When
        Boolean actual1 = newGame.isFullHouse(counts1);
        Boolean actual2 = newGame.isFullHouse(counts2);
        Boolean actual3 = newGame.isFullHouse(counts3);

        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertFalse(actual3);
    }


    @Test
    public void isThreeOfAKind() {
        // Given
        Integer[] counts1 = {3, 3, 3, 1, 1};
        Integer[] counts2 = {1, 3, 3, 3, 1};
        Integer[] counts3 = {3, 2, 3, 2, 2};

        KlondikeGameEngine newGame = new KlondikeGameEngine(new User("", 1, 1, 0.0));

        // When
        Boolean actual1 = newGame.isThreeOfAKind(counts1);
        Boolean actual2 = newGame.isThreeOfAKind(counts2);
        Boolean actual3 = newGame.isThreeOfAKind(counts3);

        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertFalse(actual3);
    }

    @Test
    public void isTwoPair() {
        // Given
        Integer[] counts1 = {2, 2, 1, 2, 2};
        Integer[] counts2 = {2, 2, 2, 2, 1};
        Integer[] counts3 = {2, 2, 1, 1, 1};

        KlondikeGameEngine newGame = new KlondikeGameEngine(new User("", 1, 1, 0.0));

        // When
        Boolean actual1 = newGame.isTwoPair(counts1);
        Boolean actual2 = newGame.isTwoPair(counts2);
        Boolean actual3 = newGame.isTwoPair(counts3);

        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertFalse(actual3);
    }

    @Test
    public void isOnePair() {
        // Given
        Integer[] counts1 = {2, 1, 2, 1, 1};
        Integer[] counts2 = {1, 2, 2, 1, 1};
        Integer[] counts3 = {1, 2, 2, 2, 2};
        KlondikeGameEngine newGame = new KlondikeGameEngine(new User("", 1, 1, 0.0));

        // When
        Boolean actual1 = newGame.isOnePair(counts1);
        Boolean actual2 = newGame.isOnePair(counts2);
        Boolean actual3 = newGame.isOnePair(counts3);

        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertFalse(actual3);

    }

    @Test
    public void getRollSequence() {
        // Given
        Integer[] counts1 = {2, 1, 2, 1, 1};
        Integer[] counts2 = {1, 2, 2, 1, 1};
        Integer[] counts3 = {1, 2, 2, 2, 2};
        KlondikeGameEngine newGame = new KlondikeGameEngine(new User("", 1, 1, 0.0));

        // When
        Boolean actual1 = newGame.isOnePair(counts1);
        Boolean actual2 = newGame.isOnePair(counts2);
        Boolean actual3 = newGame.isOnePair(counts3);

        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertFalse(actual3);

    }
    @Test
    public void getWinner() {
        // Given
        Integer[] counts1 = {2, 1, 2, 1, 1};
        Integer[] counts2 = {1, 2, 2, 1, 1};
        Integer[] counts3 = {1, 2, 2, 2, 2};
        KlondikeGameEngine newGame = new KlondikeGameEngine(new User("", 1, 1, 0.0));

        // When
        Boolean actual1 = newGame.isOnePair(counts1);
        Boolean actual2 = newGame.isOnePair(counts2);
        Boolean actual3 = newGame.isOnePair(counts3);


        // Then
        Assert.assertTrue(actual1);
        Assert.assertTrue(actual2);
        Assert.assertFalse(actual3);

    }
}