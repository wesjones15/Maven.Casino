package io.zipcoder.casino.gamestest.KlondikeTest;

import io.zipcoder.casino.games.DiceGames.klondike.KlondikeGame;
import io.zipcoder.casino.games.DiceGames.klondike.KlondikeGameEngine;
import io.zipcoder.casino.sweetasscasinotools.Dice;
import io.zipcoder.casino.sweetasscasinotools.Die;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.Art;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class KlondikeGameTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void displayKlondikeRulesTest() {
        String expected = "In Klondike Dice players need to roll better combination than banker to win.\n" +
                "The banker rolls first and the player rolls and tries to beat banker’s combination.\n" +
                "\n" +
                "Combinations are ordered in sequence from highest to lowest as follows\n" +
                "\n" +
                "Five of a kind – All 5 dice showing the same number\n" +
                "Four of a kind – 4 dice showing the same number\n" +
                "Full house – 3 dice with one number and 2 dice showing another number\n" +
                "Three of a kind – 4 dice showing the same number\n" +
                "Two pairs – 2 dice pairs showing same number\n" +
                "One pair – 2 dice showing same number\n" +
                "A die not used in any combination is ignored. If players roll same combination as of banker, then they lose.\n" +
                "They must roll a better combination to win. In case no one rolls a combination including the banker, then banker wins.";
        String actual = KlondikeGame.displayKlondikeRules();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void printNameOfCombinationTest1() {
        // Given
        Integer winPoints = 0;
        String expected = "ONE PAIR";

        // When
        String actual = KlondikeGame.printNameOfCombination(winPoints);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printNameOfCombinationTest2() {
        // Given
        Integer winPoints = 1;
        String expected = "TWO PAIR";

        // When
        String actual = KlondikeGame.printNameOfCombination(winPoints);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printNameOfCombinationTest3() {
        // Given
        Integer winPoints = 2;
        String expected = "THREE OF A KIND";

        // When
        String actual = KlondikeGame.printNameOfCombination(winPoints);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printNameOfCombinationTest4() {
        // Given
        Integer winPoints = 3;
        String expected = "FULL HOUSE";

        // When
        String actual = KlondikeGame.printNameOfCombination(winPoints);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printNameOfCombinationTest5() {
        // Given
        Integer winPoints = 4;
        String expected = "FOUR OF A KIND";

        // When
        String actual = KlondikeGame.printNameOfCombination(winPoints);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printNameOfCombinationTest6() {
        // Given
        Integer winPoints = 5;
        String expected = "FIVE OF A KIND";

        // When
        String actual = KlondikeGame.printNameOfCombination(winPoints);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dieRollTest() {
        Dice dice = KlondikeGame.dieRoll();
        Integer d1 = dice.getDie(0).roll();

        Assert.assertTrue(d1 >=1 && d1 <= 6);

    }

    @Test
    public void getNumberOfOccurrencesTest() {
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
    public void faceValueCountTest() {
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
    public void faceValueCountTest2(){
        Integer [] faceValues = {1,1,1,1,1};
        Integer [] expected = {5,5,5,5,5};
        Integer [] actual;

        actual = KlondikeGame.faceValueCount(faceValues);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isFiveOfAKindTest() {
        // Given
        Integer[] counts = {5, 5, 5, 5, 5};

        // When
        Boolean actual = KlondikeGame.isFiveOfAKind(counts);

        // Then
        Assert.assertTrue(actual);
    }

    @Test
    public void isFourOfAKindTest() {
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
    public void isFullHouseTest() {
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
    public void isThreeOfAKindTest() {
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
    public void isTwoPairTest() {
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
    public void isOnePairTest() {
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
    public void checkRollSequenceTest() {
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
    public void printFaceValues() {
        Integer [] dieFaceValues = {1,2,3,4,5,};
        String expected = "  1  2  3  4  5";
        String actual = KlondikeGame.printFaceValues(dieFaceValues);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getFaceValuesTest() {
        Dice actual = KlondikeGame.dieRoll();
        Die [] die = actual.getDieArray();
        Integer[] expected;

        expected = KlondikeGame.getFaceValues(die);
        Assert.assertTrue(expected[0] >=1 && expected[0] <= 6);
    }
}