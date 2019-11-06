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
        Console.println("Welcome to the Minimum Viable Casino: Where we do the bare minimum!\n\n");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Console.println("Let's start with a few questions...");
//        UserDisplay.run();
        User user = UserDisplay.createCasinoUser();

        casinoStart(user);

    }
    public void casinoStart(User user){
        Console.clear();
        Console.clear();
        Console.println("Welcome, %s! You have $%.2f", user.getName(), user.getWallet());
        int gameAction = UserDisplay.displayOptions("Go Fish", "Black Jack", "Klondike", "Craps", "Exit Casino");
        Console.clear();
        UserDisplay.chooseGame(gameAction, user);

    }
    public static void printDashes() {
        repeatPrint(80, "-");
        println("");
    }

    private static void repeatPrint(int i, String s) {
    }

    private static void println(String s) {
    }
}
