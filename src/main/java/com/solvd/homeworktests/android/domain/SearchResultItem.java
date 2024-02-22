package com.solvd.homeworktests.android.domain;

public class SearchResultItem {

    private String name;
    private String sport;

    public SearchResultItem(String name, String sport) {
        this.name = name;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public String getSport() {
        return sport;
    }
}
