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
    public void displayKlondikeMenu() {
        String expected = "Welcome to\n";// + Art.klondikeSign;
        KlondikeGameEngine kge = new KlondikeGameEngine(new User("KH", 1, 24, 200.0));
        String actual = kge.displayKlondikeMenu();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void leaveTableTest(){

    }

    @Test
    public void promptForBetAmount(){

    }


    @Test
    public void getWinnerTest1() {
        // Given
        Integer[] dealerRoll = {1, 2, 2, 3, 3};
        Integer[] playerRoll = {1, 3, 4, 2, 2};

        Integer[] dealerRollCounts = {1, 2, 2, 2, 2};
        Integer[] playerRollCounts = {1, 1, 1, 2, 2};
        String expected = "Dealer Wins!\n";

        // When
        KlondikeGameEngine kge = new KlondikeGameEngine(new User("KH", 1, 24, 200.0));
        String actual = kge.getWinner(dealerRollCounts, playerRollCounts);


        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWinnerTest2() {
        Integer[] dealerRoll = {3, 3, 3, 3, 5};
        Integer[] playerRoll = {2, 2, 2, 2, 1};

        Integer[] dealerRollCounts = {4, 4, 4, 4, 1};
        Integer[] playerRollCounts = {4, 4, 4, 4, 1};
        String expected = "Dealer Wins!\n";

        // When
        KlondikeGameEngine kge = new KlondikeGameEngine(new User("KH", 1, 24, 200.0));
        String actual = kge.getWinner(dealerRollCounts, playerRollCounts);

        // Then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getWinnerTest3() {
        Integer[] dealerRoll = {3, 3, 1, 2, 5};
        Integer[] playerRoll = {2, 2, 2, 2, 1};

        Integer[] dealerRollCounts = {2, 2, 1, 1, 1};
        Integer[] playerRollCounts = {4, 4, 4, 4, 1};

        String expected = "Player Wins!\n";

        // When
        KlondikeGameEngine kge = new KlondikeGameEngine(new User("KH", 1, 24, 200.0));
        String actual = kge.getWinner(dealerRollCounts, playerRollCounts);


        // Then
        Assert.assertEquals(expected, actual);

    }
}