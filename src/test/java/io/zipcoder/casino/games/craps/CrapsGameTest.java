package io.zipcoder.casino.games.craps;

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

    @Test
    public void testShowGameRules() {
        String actual = CrapsGame.showGameRules();
        String expected = "---==--===--===--==| CRAPS RULES |==--===--===--==---\nOn the first round, you win if you roll a 7 or 12\nand you lose if you roll a 2, 3, or 12" +
                "\nIf you roll something else, that number becomes\nyour win target and your losing roll becomes 7" +
                "\nYou can wager your money on whether you win the round\n" +
                "---==--===--===--========-=-========--===--===--==---\n";
        Assert.assertEquals(expected, actual);
    }
}
