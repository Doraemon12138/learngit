package com.itheima.demo;

public class Movie {
    //1.成员变量
    private String name;
    private double score;
    private String actor;
    //无参数的构造器，虽然不使用但也需要写好
    public Movie() {
    }
    //有参数的构造器
    public Movie(String name, double score, String actor) {
        this.name = name;
        this.score = score;
        this.actor = actor;
    }

    //2.getter+setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
