package io.zipcoder.casino.gamestest.craps;

import io.zipcoder.casino.games.DiceGames.craps.CrapsGameEngine;
import io.zipcoder.casino.userandplayer.User;
import org.junit.Assert;
import org.junit.Test;

public class CrapsGameEngineTest {
    @Test
    public void testInitialConstructor() {
        //TODO figure out how to test this
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
    }

    @Test
    public void testPlayAgainConstructor() {
        //TODO figure out how to test this
    }

    //TODO test displayCrapsMenu

    @Test
    public void testMenuChoice() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
//        cge.menuChoice(1)
        //TODO figure out how to test this
    }

    @Test
    public void testGeneralGameEnd0() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        String actual = cge.generalGameEnd(0, 15.00);
        String expected = "You lost Craps!\nYour remaining balance is $15.00\n";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testGeneralGameEnd1() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        String actual = cge.generalGameEnd(1, 15.00);
        String expected = "You won Craps!\nYour new balance is $15.00\n";
        Assert.assertEquals(expected, actual);
    }
    //TODO test playerWin, playerLose probs not tho
    @Test
    public void testGameContinue1() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer[] winRolls = {7, 11};
        Integer[] actual = {7};//cge.gameContinue(4, winRolls);
        Integer[] expected = {4};
        Assert.assertEquals(expected.length, actual.length);
        Assert.assertEquals(expected[0], actual[0]);
    }
    @Test
    public void testGameContinue2() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer[] winRolls = {8};
        Integer[] actual = {};//cge.gameContinue(4, winRolls);
        Integer[] expected = winRolls;
        Assert.assertEquals(expected.length, actual.length);
        Assert.assertEquals(expected[0], actual[0]);
    }

    @Test
    public void testPayOutRewardToPlayer() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Double actual = cge.payOutRewardToPlayer(30.00);
        Double expected = 60.00;
        Assert.assertEquals(expected, actual, 2);
    }

    @Test
    public void testShowRollsForOutcome1() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer[] winRolls = {7, 11};
        String actual = cge.showRollsForOutcome("Winning", winRolls);
        String expected = "Winning Rolls:\t7\t11";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testShowRollsForOutcome2() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer[] winRolls = {4};
        String actual = cge.showRollsForOutcome("Winning", winRolls);
        String expected = "Winning Rolls:\t4";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testShowRollsForOutcome3() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer[] loseRolls = {2, 3, 12};
        String actual = cge.showRollsForOutcome("Losing", loseRolls);
        String expected = "Losing Rolls:\t2\t3\t12";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testShowRollsForOutcome4() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer[] loseRolls = {7};
        String actual = cge.showRollsForOutcome("Losing", loseRolls);
        String expected = "Losing Rolls:\t7";
        Assert.assertEquals(expected, actual);
    }

    //TODO write tests for methods requiring user input
//    @Test
//    public void testChooseGameOption() {
//
//    }
//    @Test
//    public void testPromptUserForBetAmount() {
//
//    }
//    @Test
//    public void testPromptUserToRollDice() {
//
//    }
//    @Test
//    public void testLeaveTable() {
//
//    }

}
