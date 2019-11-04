package io.zipcoder.casino;


import io.zipcoder.casino.utilities.Console;

public class Casino {
    ///All Declarations
    private User user;
    private UserDisplay userDisplay;

             //Contructors
    public Casino(){
        start();
    }
    public Casino(String name, Double wallet){
        this.user.setName(name);
        this.user.setWallet(wallet);
        start();
    }



    public void start(){
        Console.println("Welcome to the great 4 Casino!");
        userDisplay.run();

    }
}
