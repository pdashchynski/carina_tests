package com.solvd.homeworktests.web.domain;

import com.zebrunner.carina.utils.R;

public enum Items {

    FIRST(1, R.TESTDATA.get("item1.title"), Double.parseDouble(R.TESTDATA.get("item1.price"))),
    SECOND(1, R.TESTDATA.get("item2.title"), Double.parseDouble(R.TESTDATA.get("item2.price"))),
    THIRD(1, R.TESTDATA.get("item3.title"), Double.parseDouble(R.TESTDATA.get("item3.price")));

    private final int index;
    private final String title;
    private final double price;

    Items(int index, String title, double price) {
        this.index = index;
        this.title = title;
        this.price = price;
    }

    public int getIndex() {
        return index;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
