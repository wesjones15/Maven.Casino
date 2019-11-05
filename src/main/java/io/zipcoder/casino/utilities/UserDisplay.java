package io.zipcoder.casino.utilities;

import io.zipcoder.casino.games.CardGames.blackjack.BlackJackGameEngine;
import io.zipcoder.casino.games.CardGames.gofish.GoFishGameEngine;
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
//        UserVillage userVillage = new UserVillage();
        User user = createCasinoUser();
        int action = displayOptions("create new user", "login", "exit");
        executeAction(action);


    }

    public static User createCasinoUser() {
        String name = Console.getStringInput("name: ");
        Integer age = Console.getIntegerInput("age: ");
        Double wallet = Console.getDoubleInput("wallet: ");
        return  new User(name, 2, age, wallet);
    }

    public  static void executeAction(int action) {
        switch(action) {
            case 1:
                // create new user
//                userVillage.createNewUser();
                Console.println("creating user");
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
    public  static void chooseGame(int action, User user) {
        switch(action) {
            case 1:
                // gofish
                GoFishGameEngine gfge = new GoFishGameEngine(user);
                gfge.runGame();
                break;
            case 2:
                BlackJackGameEngine bjge = new BlackJackGameEngine(user);
                bjge.runGame();
                // black jack
                break;
            case 3:
                // klondike
                break;
            case 4:
                // craps
            case 5:
                Console.println("Thank you!, Come again");
                Console.exit();
            default:
                Console.println("Bitch wrong input, try again!");
                break;
        }
    }
}
