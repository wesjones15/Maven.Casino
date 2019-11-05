package io.zipcoder.casino.utilities;


import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.utilities.Console;

public class Casino {
    // All Declarations
    private User user = new User();
//    private UserDisplay userDisplay;

    // Constructors
    public Casino(){
        userStart();

    }
    public Casino(String name, Double wallet){
        this.user.setName(name);
        this.user.setWallet(wallet);
        casinoStart(user);
    }



    public void userStart(){
        Console.println("Welcome to the great 4 Casino!");
//        UserDisplay.run();
        User user = UserDisplay.createCasinoUser();

        casinoStart(user);

    }
    public void casinoStart(User user){
        Console.println("Welcome, %s! You have $%.2f", user.getName(), user.getWallet());
        int gameAction = UserDisplay.displayOptions("Go Fish", "Black Jack", "Klondike", "Craps", "Exit Casino");
        UserDisplay.chooseGame(gameAction, user);
    }
}
