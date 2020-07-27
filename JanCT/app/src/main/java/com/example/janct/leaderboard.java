package com.example.janct;

public class leaderboard {

    private Integer score;
    private String username;

    public leaderboard(){}

    public leaderboard(Integer socre,String username)
    {
        this.score=score;
        this.username=username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
