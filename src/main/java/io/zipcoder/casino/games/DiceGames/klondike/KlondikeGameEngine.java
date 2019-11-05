package io.zipcoder.casino.games.DiceGames.klondike;

import io.zipcoder.casino.utilities.Casino;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.userandplayer.User;


public class KlondikeGameEngine {

    private User user;
    private KlondikePlayer klondikePlayer;
    private KlondikeDealer klondikeDealer;
    private KlondikeGame klondikeGame;

    public KlondikeGameEngine(User user) {
        this.user = user;
        this.klondikePlayer = new KlondikePlayer(user);
        this.klondikeDealer = new KlondikeDealer();
        this.klondikeGame = new KlondikeGame();
    }

    public void displayKlondikeMenu() {
        optionChosen(Console.getIntegerInput("Welcome to Klondike!\n" +
                "1 : Start Game\n" +
                "2 : View Klondike Rules\n" +
                "3 : Leave Game"));
    }

    public void optionChosen(Integer choice) {
        switch (choice) {
            case 1:
                //runKlondike();
                break;
            case 2:
                //displayKlondikeRules();
                break;
            case 3:
                //leaveGame();
                break;
            default:
                Console.println("Invalid response!");
                break;
        }
    }

    public void runKlondike() {
        //displayKlondikeMenu()
        //klondikeGame.roll();
    }

    public Boolean getWinner() {
        return null;
    }

    //Supporting Methods


    public String displayKlondikeRules() {
        return null;
    }

    public void leaveGame() {
        new Casino(user.getName(), user.getWallet());
    }
}

