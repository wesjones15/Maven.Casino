package io.zipcoder.casino.games.DiceGames.klondike;

import io.zipcoder.casino.sweetasscasinotools.Dice;
import io.zipcoder.casino.sweetasscasinotools.Die;
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
        Console.println("Welcome to Klondike!\n" +
                "1 : Start Game\n" +
                "2 : View Klondike Rules\n" +
                "3 : Leave Game");
    }

    public Integer choiceFromKlondikeMenu() {
        Integer choice = Console.getIntegerInput("What do you want to do?");
        return choice;
    }

    public void executeActionChosen(Integer choice) {
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
                //Console.println("Invalid response!");
                displayKlondikeMenu();
                break;
        }
    }

    public void run() {
        displayKlondikeMenu();
        Integer action = choiceFromKlondikeMenu();
        executeActionChosen(action);
    }

    public void runKlondike() {
        Dice dealerDice = new Dice(5, 6);
        Dice playerDice = new Dice(5, 6);//klondikeDealer rolls;

        //klondikePlayer rolls;
        //compare rolls
        //getWinner()

    }

    public Boolean getWinner() {
        return null;
    }

    //Supporting Methods

    public Die[] rollDie() {

        return null;
    }

    public String displayKlondikeRules() {
        return null;
    }


}

