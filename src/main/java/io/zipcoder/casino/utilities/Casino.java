package io.zipcoder.casino.utilities;


import io.zipcoder.casino.userandplayer.User;

public class Casino {
    // All Declarations
    private User user = new User();

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
        Console.println(Art.minViableSign + "\n\n" + Art.casinoSign);
        Console.println("Welcome to the Minimum Viable Casino: Where we do the bare minimum!\n\n");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Console.println("Let's start with a few questions...");
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
    
}
