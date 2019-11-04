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
    public User(){
        //fuck this
    }

    public void chooseGame() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getWallet() {
        return wallet;
    }

    public void setWallet(Double wallet) {
        this.wallet = wallet;
    }
}
