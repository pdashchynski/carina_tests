package com.solvd.homeworktests.web.domain;

public class User {

    private final String login;
    private final String pass;

    public User(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }
}
