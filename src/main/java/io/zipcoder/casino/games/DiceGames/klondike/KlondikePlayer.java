package io.zipcoder.casino.games.DiceGames.klondike;

import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.Casino;

public class KlondikePlayer {
    private User user;

    public KlondikePlayer(User user) {
        this.user = user;
    }

    //public Integer[] roll(Integer numOfDie) {return null;}

    public void leaveGame() {
        new Casino(user.getName(), user.getWallet());
    }

    public void bet(Double betAmount){}
}
