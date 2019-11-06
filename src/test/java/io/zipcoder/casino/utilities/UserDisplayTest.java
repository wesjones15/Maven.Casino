package io.zipcoder.casino.utilities;

import io.zipcoder.casino.userandplayer.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class UserDisplayTest {

    @Test
    public void displayOptions() {
    }

    // the test below is terrible, Reevaluate
    @Test
    public void testCreateCasinoUser() {
            String name = "Gambling fellow";
            Integer age = 1;
            Double wallet = 1.0;
        User user = new User(name,2, age, wallet);
        String expected = "Gambling fellow 1 1.0";
        String actual = user.getName() + " " + user.getAge() + " " + user.getWallet();

    }
    @Test
    public void testGetName(){
        String name = "Gambling fellow";
        Integer age = 1;
        Double wallet = 1.0;
        User user = new User(name,2, age, wallet);

        String expected = "Gambling fellow";
        String actual = user.getName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testGetWallet() {
            String name = "Gambling fellow";
            Integer age = 1;
            Double wallet = 1.0;
            User user = new User(name,2, age, wallet);

        Double expected = 1.0;
        Double actual = user.getWallet();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testValidateWallet(){
        //Unable to test currently
    }

    @Test
    public void testGetAge() {
            String name = "Gambling fellow";
            Integer age = 1;
            Double wallet = 1.0;
            User user = new User(name,2, age, wallet);

        Integer expected = 1;
        Integer actual = user.getAge();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void validateAge(){
        //Unable to test currently
    }

    @Test
    public void executeAction1() {
        String expected = "create new user";
        String actual = UserDisplay.executeAction(1);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void executeAction2() {
        String expected = "login with existing user";
        String actual = UserDisplay.executeAction(2);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void executeAction3() {
        String expected = "exit casino";
        String actual = UserDisplay.executeAction(3);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void executeAction4() {
        String expected = "default";
        String actual = UserDisplay.executeAction(3);

        Assert.assertEquals(expected,actual);
    }

// These tests call the game engines , which prompt for input. Re evaluate
    @Test
    public void chooseGame1() {

        User user = new User("name",2, 19, 1.0);

        String expected = "gofish";
        String actual = UserDisplay.chooseGame(1,user);

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void chooseGame2() {

        User user = new User("name",2, 19, 1.0);

        String expected = "black jack";
        String actual = UserDisplay.chooseGame(2,user);

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void chooseGame3() {

        User user = new User("name",2, 19, 1.0);

        String expected = "klondike";
        String actual = UserDisplay.chooseGame(3,user);

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void chooseGame4() {

        User user = new User("name",2, 19, 1.0);

        String expected = "craps";
        String actual = UserDisplay.chooseGame(4,user);

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void chooseGame5() {

        User user = new User("name",2, 19, 1.0);

        String expected = "Leaving";
        String actual = UserDisplay.chooseGame(5,user);

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void chooseGame6() {

        User user = new User("name",2, 19, 1.0);

        String expected = "default";
        String actual = UserDisplay.chooseGame(6,user);

        Assert.assertEquals(expected,actual);
    }
}
