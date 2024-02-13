package com.solvd.homeworktests.web.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.Objects;

public class ItemCard {
    private String title;
    private double price;

    public ItemCard() {
    }

    public ItemCard(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, price);
    }
}

