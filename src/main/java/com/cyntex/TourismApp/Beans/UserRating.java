package com.cyntex.TourismApp.Beans;

public class UserRating {
    private final String category;
    private final double rating;

    public UserRating(String category, double rating) {
        this.category = category;
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }
}
