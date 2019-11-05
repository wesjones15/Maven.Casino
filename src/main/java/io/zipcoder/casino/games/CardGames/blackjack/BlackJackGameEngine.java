package io.zipcoder.casino.games.CardGames.blackjack;
import io.zipcoder.casino.games.TypesOfGames.CardGameClass;
import io.zipcoder.casino.userandplayer.PlayerClass;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.UserDisplay;

public class BlackJackGameEngine {

    private BlackJackPlayer[] currentPlayers;
    private BlackJackDealer dealer;

    public void start() {

        play();
        dealer.hit();
        play();
    }

    public void play() {
        for (BlackJackPlayer player : currentPlayers) {
            play(player);
        }
    }

    private void play(BlackJackPlayer player) {
    }
}