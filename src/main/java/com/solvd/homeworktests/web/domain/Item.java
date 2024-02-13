package com.solvd.homeworktests.web.domain;

public class Item {

    private final int index;
    private final String title;
    private final double price;

    public Item(int index, String title, double price) {
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
