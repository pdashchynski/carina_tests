package com.solvd.homeworktests.web.domain;

import com.zebrunner.carina.utils.R;

public enum Users {

    VALID(R.TESTDATA.get("valid.login"), R.TESTDATA.get("valid.pass")),
    INVALID(R.TESTDATA.get("invalid.login"), R.TESTDATA.get("invalid.pass"));

    private final String login;
    private final String pass;

    Users(String login, String pass) {
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
