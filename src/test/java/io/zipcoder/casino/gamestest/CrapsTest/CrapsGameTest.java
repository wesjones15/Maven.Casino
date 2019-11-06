package io.zipcoder.casino.gamestest.CrapsTest;

import io.zipcoder.casino.games.DiceGames.craps.CrapsGame;
import org.junit.Assert;
import org.junit.Test;

public class CrapsGameTest {
    @Test
    public void testDetermineRollOutcome1() {
        Integer rollValue = 5;
        Integer[] winRolls = {4};
        Integer[] loseRolls = {7};

        Integer actual = CrapsGame.determineRollOutcome(rollValue,winRolls,loseRolls);
        Integer expected = 5;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDetermineRollOutcome2() {
        Integer rollValue = 5;
        Integer[] winRolls = {7, 11};
        Integer[] loseRolls = {2, 3, 12};

        Integer actual = CrapsGame.determineRollOutcome(rollValue,winRolls,loseRolls);
        Integer expected = 5;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testDetermineRollOutcome3() {
        Integer rollValue = 2;
        Integer[] winRolls = {7, 11};
        Integer[] loseRolls = {2, 3, 12};

        Integer actual = CrapsGame.determineRollOutcome(rollValue,winRolls,loseRolls);
        Integer expected = 0;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testDetermineRollOutcome4() {
        Integer rollValue = 5;
        Integer[] winRolls = {5};
        Integer[] loseRolls = {7};

        Integer actual = CrapsGame.determineRollOutcome(rollValue,winRolls,loseRolls);
        Integer expected = 1;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testDetermineRollOutcome5() {
        Integer rollValue = 4;
        Integer[] winRolls = {4};
        Integer[] loseRolls = {7};

        Integer actual = CrapsGame.determineRollOutcome(rollValue,winRolls,loseRolls);
        Integer expected = 1;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCheckRollMatch1() {
        Integer rollValue = 4;
        Integer[] numsToCheck = {1, 2, 4, 6, 12};
        Boolean match = CrapsGame.checkRollMatch(rollValue, numsToCheck);
        Assert.assertTrue(match);
    }

    @Test
    public void testCheckRollMatch2() {
        Integer rollValue = 7;
        Integer[] numsToCheck = {7, 11};
        Boolean match = CrapsGame.checkRollMatch(rollValue, numsToCheck);
        Assert.assertTrue(match);
    }

    @Test
    public void testCheckRollMatch3() {
        Integer rollValue = 4;
        Integer[] numsToCheck = {7, 11};
        Boolean match = CrapsGame.checkRollMatch(rollValue, numsToCheck);
        Assert.assertFalse(match);
    }
}
