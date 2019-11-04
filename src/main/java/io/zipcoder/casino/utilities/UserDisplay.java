package io.zipcoder.casino.utilities;

import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.userandplayer.UserVillage;

import io.zipcoder.casino.utilities.Console;

public class UserDisplay {
    private UserVillage userVillage;
    private User user;
    private String name;


    public Boolean verifyAge() {
        return null;
    }

    private void displayMenu() {
        // 1 : login
        // 2 : exit
        // Choose action:
//        promptForUserCreation(Console.getIntegerInput("Welcome to casino\n" +
//                "1 - login\n" +
//                "2 - Exit");
    }
    private void promptForUserCreation(int i) {
        switch(i){

        }
    }
    private String promptForName(String name) {
        return null;
    }
    private String promptForExistingUser(Integer userId, String name) {
        return "Welcome to Casino";
    }
    private void promptForGameChoice() {

    }

//    BlackJackGameEngine
//    GoFishGameEngine
//    CrapsGameEngine
//    KlondikeGameEngine

    public static Integer displayOptions(String... options) {
        for (int i = 0; i < options.length; i++) {
            Console.println("%s : %s", i+1, options[i]);
        }
        return Console.getIntegerInput("Select your action: ");
    }

    public static void run() {
        UserVillage userVillage = new UserVillage();
        int action = displayOptions("create new user", "login", "exit");
        executeAction(action);
    }

    public  static void executeAction(int action) {
        switch(action) {
            case 1:
                // create new user

                break;
            case 2:
                // login with existing user
                break;
            case 3:
                //exit casino
                System.exit(0);
                break;
            default:
                break;
        }
    }
}
