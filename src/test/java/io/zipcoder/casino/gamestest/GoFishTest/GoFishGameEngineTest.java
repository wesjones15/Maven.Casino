package io.zipcoder.casino.gamestest.GoFishTest;

import io.zipcoder.casino.games.CardGames.gofish.GoFishGameEngine;
import io.zipcoder.casino.games.CardGames.gofish.GoFishPlayer;
import io.zipcoder.casino.sweetasscasinotools.Card;
import io.zipcoder.casino.userandplayer.User;
import org.junit.Assert;
import org.junit.Test;

public class GoFishGameEngineTest {
    @Test
    public void goFishGameEngineConstructor_Test(){
        //Given
        User user = new User();
        Double expected = 100.0;
        user.setWallet(expected);

        //When
        GoFishGameEngine goFishGameEngine = new GoFishGameEngine(user);

        //Then
        Assert.assertEquals(expected, goFishGameEngine.getUser().getWallet());

    }

    @Test
    public void dealHands_Test(){
        //Given
        User user = new User();
        GoFishGameEngine goFishGameEngine = new GoFishGameEngine(user);

        //When
        goFishGameEngine.dealHands();

        //Then check is player has cards in his hand.
        Assert.assertNotNull(goFishGameEngine.getGoFishPlayer().getHand());
    }

    @Test
    public void askedCards_Test(){
        //Given
        User user = new User();
        GoFishGameEngine goFishGameEngine = new GoFishGameEngine(user);

        //When
        goFishGameEngine.dealHands();
        Card randomCard = goFishGameEngine.askedCard();

        //Then
        Assert.assertNotNull(randomCard);
    }

    @Test
    public void getgoFishPlayer_Test(){
        //given
        User user = new User();
        GoFishGameEngine goFish = new GoFishGameEngine(user);
        GoFishPlayer goFishPlayer = goFish.getGoFishPlayer();

        //Then
        Assert.assertEquals(goFishPlayer, goFish.getGoFishPlayer());

    }
    @Test
    public void checkWinner_Test(){
        //given
        User user = new User();
        GoFishGameEngine goFish = new GoFishGameEngine(user);

        //when
        goFish.dealHands();

        //then
        Assert.assertFalse(goFish.checkWinner(goFish.getGoFishPlayer(), goFish.getGoFishPlayer()));
    }
}
