package io.zipcoder.casino.utilities;

import io.zipcoder.casino.userandplayer.User;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class UserDisplayTest {

    @Test
    public void displayOptions1() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Integer actual = UserDisplay.displayOptions("Start Game", "Leave Table", "Show Rules");
        Integer expected = Integer.valueOf(input);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void displayOptions2() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Integer actual = UserDisplay.displayOptions("Start Game", "Leave Table", "Show Rules");
        Integer expected = Integer.valueOf(input);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void displayOptions3() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Integer actual = UserDisplay.displayOptions("Start Game", "Leave Table", "Show Rules");
        Integer expected = Integer.valueOf(input);
        Assert.assertEquals(expected, actual);
    }

    // the test below is terrible, Reevaluate
    //TODO write test for createCasinoUser
    @Test
    public void testCreateCasinoUser() {
            String name = "Gambling fellow";
            Integer age = 1;
            Double wallet = 1.0;
        User user = new User(name,2, age, wallet);
        String expected = "Gambling fellow 1 1.0";
        String actual = user.getName() + " " + user.getAge() + " " + user.getWallet();

    }
    // Test below don't belong here
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
    public void testValidateAge() {
        String input = "19";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Integer actual = UserDisplay.validateAge();
        Integer expected = Integer.valueOf(input);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testValidateWallet() {
        String input = "14.2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Double actual = UserDisplay.validateWallet();
        Double expected = Double.valueOf(input);
        Assert.assertEquals(expected, actual, 2);
    }




}
