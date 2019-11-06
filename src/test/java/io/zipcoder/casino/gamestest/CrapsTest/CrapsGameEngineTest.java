package io.zipcoder.casino.gamestest.CrapsTest;

import io.zipcoder.casino.games.DiceGames.craps.CrapsGameEngine;
import io.zipcoder.casino.userandplayer.User;
import org.junit.Test;

public class CrapsGameEngineTest {
    @Test
    public void testInitialConstructor() {
        CrapsGameEngine cge = new CrapsGameEngine(new User("Wes", 2, 22, 24.44));

    }

    @Test
    public void testPlayAgainConstructor() {

    }


}
