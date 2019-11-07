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
    public void testGetAge() {
            String name = "Gambling fellow";
            Integer age = 1;
            Double wallet = 1.0;
            User user = new User(name,2, age, wallet);

        Integer expected = 1;
        Integer actual = user.getAge();
        Assert.assertEquals(expected,actual);
    }



}
