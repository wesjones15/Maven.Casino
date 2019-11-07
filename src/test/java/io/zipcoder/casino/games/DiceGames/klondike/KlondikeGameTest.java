package io.zipcoder.casino.games.DiceGames.klondike;

import io.zipcoder.casino.userandplayer.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class KlondikeGameTest {

    @Test
    public void checkRollSequence() {
    }

    @Test
    public void getFaceValuesTest() {
    }

    @Test
    public void faceValueCountsTest() {
    }

    @Test
    public void getNumberOfOccurrences() {
        // Given
        Integer[] faceValues = {2, 4, 3, 3, 6};
        Integer value = 3;
        Integer expected = 2;

        // When
        Integer actual = KlondikeGame.getNumberOfOccurrences(faceValues, value);

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void faceValueCount() {
        // Given
        Integer[] faceValues = {2, 4, 1, 2, 5};
        Integer[] expected2 = {2, 1, 1, 2, 1};

        // When
        Integer[] actual = KlondikeGame.faceValueCount(faceValues);
        System.out.println(Arrays.toString(actual));

        // Then
        Assert.assertEquals(expected2, actual);
    }

    @Test
    public void isFiveOfAKind() {
        // Given
        Integer[] counts = {5, 5, 5, 5, 5};

        // When
        Boolean actual = KlondikeGame.isFiveOfAKind(counts);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void isFourOfAKind() {
        // Given
        Integer[] counts1 = {4, 4, 4, 4, 1};
        Integer[] counts2 = {1, 4, 4, 4, 4};
        Integer[] counts3 = {4, 1, 4, 4, 4};
        Integer[] counts4 = {4, 4, 1, 4, 4};
        Integer[] counts5 = {4, 4, 4, 1, 4};

        // When
        //Boolean actual = newGame.isFourOfAKind(newGame.faceValueCount(faceValues));
        Boolean actual1 = KlondikeGame.isFourOfAKind(counts1);
        Boolean actual2 = KlondikeGame.isFourOfAKind(counts2);
        Boolean actual3 = KlondikeGame.isFourOfAKind(counts3);
        Boolean actual4 = KlondikeGame.isFourOfAKind(counts4);
        Boolean actual5 = KlondikeGame.isFourOfAKind(counts5);

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

        // When
        Boolean actual1 = KlondikeGame.isFullHouse(counts1);
        Boolean actual2 = KlondikeGame.isFullHouse(counts2);
        Boolean actual3 = KlondikeGame.isFullHouse(counts3);

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

        // When
        Boolean actual1 = KlondikeGame.isThreeOfAKind(counts1);
        Boolean actual2 = KlondikeGame.isThreeOfAKind(counts2);
        Boolean actual3 = KlondikeGame.isThreeOfAKind(counts3);

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

        // When
        Boolean actual1 = KlondikeGame.isTwoPair(counts1);
        Boolean actual2 = KlondikeGame.isTwoPair(counts2);
        Boolean actual3 = KlondikeGame.isTwoPair(counts3);

        // Then
        assertTrue(actual1);
        assertTrue(actual2);
        assertFalse(actual3);
    }

    @Test
    public void isOnePair() {
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

    @Test
    public void getRollSequence() {
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