package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;

public class UserVillage {
    private ArrayList<User> users;
    private User dealer;//maybe?

    public UserVillage() {
        this.users = new ArrayList<User>();
    }

    public void createNewUser() {
        String name = Console.getStringInput("name: ");
        Integer age = Console.getIntegerInput("age: ");
        Double wallet = Console.getDoubleInput("wallet: ");
        Integer id = users.size() + 1;
        users.add(new User(name, id, age, wallet));

    }

    public User getUserByUsername(String username) {
        return null;
    }

    public User getUserById(Integer id) {
        return null;
    }
}
