package io.zipcoder.casino.userandplayertest;

import io.zipcoder.casino.userandplayer.User;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {
    @Test
    public void userContructorTest(){
        //Given
        String name = "chung";
        Integer id = 10;
        Integer age = 29;
        Double wallet = 100.0;


        //When
        User user = new User(name, id, age, wallet);
        String expectedName = name;

        //then
        Assert.assertEquals(expectedName, user.getName());


    }
}
