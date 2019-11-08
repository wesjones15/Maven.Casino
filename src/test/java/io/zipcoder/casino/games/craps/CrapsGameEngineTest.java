package io.zipcoder.casino.games.craps;

import io.zipcoder.casino.games.DiceGames.craps.CrapsGameEngine;
import io.zipcoder.casino.userandplayer.User;
import org.junit.Assert;
import org.junit.Test;

public class CrapsGameEngineTest {
//    @Test
//    public void testInitialConstructor() {
//        //TODO figure out how to test this
//        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
//
//    }
//
//    @Test
//    public void testPlayAgainConstructor() {
//        //TODO figure out how to test this
//
//    }

    @Test
    public void testDisplayCrapsMenu() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        String actual = cge.displayCrapsMenu();
        String expected =
                "                                                  \n" +
                " @@@@@@@  @@@@@@@    @@@@@@   @@@@@@@    @@@@@@   \n" +
                "@@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@@  @@@@@@@   \n" +
                "!@@       @@!  @@@  @@!  @@@  @@!  @@@  !@@       \n" +
                "!@!       !@!  @!@  !@!  @!@  !@!  @!@  !@!       \n" +
                "!@!       @!@!!@!   @!@!@!@!  @!@@!@!   !!@@!!    \n" +
                "!!!       !!@!@!    !!!@!!!!  !!@!!!     !!@!!!   \n" +
                ":!!       !!: :!!   !!:  !!!  !!:            !:!  \n" +
                ":!:       :!:  !:!  :!:  !:!  :!:           !:!   \n" +
                " ::: :::  ::   :::  ::   :::   ::       :::: ::   \n" +
                " :: :: :   :   : :   :   : :   :        :: : :    \n" +
                "                                                  \n" +
                "\nWelcome to Craps!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testExecuteMenuChoice1() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Boolean actual = cge.executeMenuChoice(1);
        Assert.assertTrue(actual);
    }
    @Test
    public void testExecuteMenuChoice2() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Boolean actual = cge.executeMenuChoice(2);
        Assert.assertFalse(actual);
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

    @Test
    public void testDisplayRollsAndBetAmount1() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer[] winRolls = {7, 11};
        Integer[] loseRolls = {2, 3, 12};
        Double betAmount = 45.00;
        String actual = cge.displayRollsAndBetAmount(winRolls, loseRolls, betAmount);
        String expected = "Winning Rolls:\t7\t11\nLosing Rolls:\t2\t3\t12\nCurrent Wager: $45.00";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDisplayRollsAndBetAmount2() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer[] winRolls = {5};
        Integer[] loseRolls = {7};
        Double betAmount = 24.56;
        String actual = cge.displayRollsAndBetAmount(winRolls, loseRolls, betAmount);
        String expected = "Winning Rolls:\t5\nLosing Rolls:\t7\nCurrent Wager: $24.56";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPayOutRewardToPlayer1() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Double actual = cge.payOutRewardToPlayer(3243.33);
        Double expected = 6486.66;
        Assert.assertEquals(expected, actual, 2);
    }
    @Test
    public void testPayOutRewardToPlayer2() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Double actual = cge.payOutRewardToPlayer(30.00);
        Double expected = 60.00;
        Assert.assertEquals(expected, actual, 2);
    }
    @Test
    public void testPayOutRewardToPlayer3() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Double actual = cge.payOutRewardToPlayer(0.49);
        Double expected = 0.98;
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

    @Test
    public void testDisplayBetInfo1() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        String actual = cge.displayBetInfo(10.00, 45.00);
        String expected = "You are wagering $10.00\nYour remaining balance is $45.00\n";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDisplayBetInfo2() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        String actual = cge.displayBetInfo(43.33, 34.00);
        String expected = "You are wagering $43.33\nYour remaining balance is $34.00\n";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDisplayBetInfo3() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        String actual = cge.displayBetInfo(1000.00, 12132.22);
        String expected = "You are wagering $1000.00\nYour remaining balance is $12132.22\n";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testExecuteDiceRoll1() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer actual = cge.executeDiceRoll(0);
        Integer expected = 0;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testExecuteDiceRoll2() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer actual = cge.executeDiceRoll(1);
        Assert.assertTrue(actual <= 12 && actual >= 2);
    }

    @Test
    public void testDisplayDiceRoll1() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        String actual = cge.displayDiceRoll(4);
        String expected = "\n\nYou rolled 4";
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDisplayDiceRoll2() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        String actual = cge.displayDiceRoll(8);
        String expected = "\n\nYou rolled 8";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateRollConditions1() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer[] newWinRoll = {4};
        Integer[] actual = cge.updateRollConditions(newWinRoll);
        Integer[] expected = {4};
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testUpdateRollConditions2() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));
        Integer[] newWinRoll = {7, 11};
        Integer[] actual = cge.updateRollConditions(newWinRoll);
        Integer[] expected = {7, 11};
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
