package com.cyntex.TourismApp.Beans;

public class RatingsProfileQueryResponseBean {

    private final String category;
    private final int rating;

    public RatingsProfileQueryResponseBean(String category, int rating) {
        this.category = category;
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }

    public int getRating() {
        return rating;
    }
}
