package io.zipcoder.casino.utilities;

import io.zipcoder.casino.games.CardGames.blackjack.BlackJackGame;
import io.zipcoder.casino.games.CardGames.blackjack.BlackJackGameEngine;
import io.zipcoder.casino.games.CardGames.gofish.GoFishGameEngine;
import io.zipcoder.casino.games.DiceGames.craps.CrapsGameEngine;
import io.zipcoder.casino.games.DiceGames.klondike.KlondikeGameEngine;
import io.zipcoder.casino.userandplayer.User;
import io.zipcoder.casino.userandplayer.UserVillage;


import io.zipcoder.casino.utilities.Console;

public class UserDisplay {
    private UserVillage userVillage;
    private User user;
    private String name;

 // Not currently Using
//    public Boolean verifyAge() {
//        return null;
//    }
//
//    private void displayMenu() {
//        // 1 : login
//        // 2 : exit
//        // Choose action:
////        promptForUserCreation(Console.getIntegerInput("Welcome to casino\n" +
////                "1 - login\n" +
////                "2 - Exit");
//    }
//    private void promptForUserCreation(int i) {
//        switch(i){
//
//        }
//    }
//    private String promptForName(String name) {
//        return null;
//    }
//    private String promptForExistingUser(Integer userId, String name) {
//        return "Welcome to Casino";
//    }
//    private void promptForGameChoice() {
//
//    }

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
//        UserVillage userVillage = new UserVillage(); Not currently using userVillage
        User user = createCasinoUser();
        int action = displayOptions("create new user", "login", "exit");
        executeAction(action);
    }

    public static User createCasinoUser() {
        String name ;
        Integer age;
        Double wallet;
        name = Console.getStringInput("Name: ");
        do {
            age = Console.getIntegerInput("Age(minimum age 18): ");
        }while(age < 18);
        do {
            wallet = Console.getDoubleInput("Monies in your wallet: ");
        }while(wallet < 0);
        return  new User(name, 2, age, wallet);
    }


    public  static String executeAction(int action) {
        String stringForTesting = "";

        switch(action) {
            case 1:
                // create new user
//                userVillage.createNewUser();
                stringForTesting = "create new user";
                Console.println("creating user");
                break;
            case 2:
                // login with existing user
                stringForTesting = "login with existing user";
                break;
            case 3:
                //exit casino
                stringForTesting = "exit casino";
                System.exit(0);
                break;
            default:
                stringForTesting = "default";
                break;
        }
        return stringForTesting;
    }
    public  static String chooseGame(int action, User user) {
        String stringForTesting = " ";
        switch(action) {
            case 1:
                // gofish
                stringForTesting = "gofish";
                GoFishGameEngine gfge = new GoFishGameEngine(user);
                gfge.displayGoFishMenu();
                break;
            case 2:
                // black jack
                BlackJackGameEngine bjGame = new BlackJackGameEngine(user);
                stringForTesting = "black jack";
                break;
            case 3:
                // klondike
                KlondikeGameEngine newKlondikeGame = new KlondikeGameEngine(user);
                newKlondikeGame.run();
                stringForTesting = "klondike";
                break;
            case 4:
                // craps
                stringForTesting = "craps";
                CrapsGameEngine cge = new CrapsGameEngine(user);
                cge.run();
                break;
            case 5:
                stringForTesting = "Leaving";
                Console.println("Thank you!, Come again");
                Console.exit();
            default:
                stringForTesting = "default";
                break;
        }
        return stringForTesting;
    }

}
