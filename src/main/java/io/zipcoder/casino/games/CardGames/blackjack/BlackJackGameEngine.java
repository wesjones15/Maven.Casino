package io.zipcoder.casino.games.CardGames.blackjack;

import io.zipcoder.casino.userandplayer.User;


public class BlackJackGameEngine {
    private BlackJackDealer blackJackDealer;
    private BlackJackPlayer blackJackPlayer;

    public BlackJackGameEngine(User user) {
        this.blackJackDealer = new BlackJackDealer();
        this.blackJackPlayer = new BlackJackPlayer(user);
        runGame();
    }

    private void runGame() {
        BlackJackGame game = new BlackJackGame(blackJackPlayer, blackJackDealer);
        game.run();
    }
}