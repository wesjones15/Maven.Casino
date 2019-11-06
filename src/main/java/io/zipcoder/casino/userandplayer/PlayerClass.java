package io.zipcoder.casino.userandplayer;

public class PlayerClass {
    private final User user;
    private final Integer userId;

    public PlayerClass(User user) {
        this.user = user;
        this.userId = user.getUserId();
    }
    public User getUser(){
        return user;
    }

    public void leaveTable() {}
    public void cashOut() {}
}
