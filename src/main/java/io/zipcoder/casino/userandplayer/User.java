package io.zipcoder.casino.userandplayer;

public class User {
    private String name;
    private Integer userId;
    private Integer age;
    private Double wallet;

    public User(String name, Integer userId, Integer age, Double wallet) {
        this.name = name;
        this.userId = userId;
        this.age = age;
        this.wallet = wallet;
    }

    public void chooseGame() {

    }
    public Double getWallet(){
        return this.wallet;
    }
    public void setWallet(double newWallet){
        this.wallet = newWallet;
    }
}
