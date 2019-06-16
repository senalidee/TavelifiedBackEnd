package com.cyntex.TourismApp.Beans;

public class ShopDetailsQueryResultBean extends BaseResponse{
    private final String shopName;
    private final int shopID;
    private final String longitude;
    private final String latitude;
    private final String foodName;
    private final int foodID;
    private final Double foodPrice;

    public ShopDetailsQueryResultBean(String shopName, int shopID, String longitude,
                                      String latitude, String foodName, int foodID, Double foodPrice) {
        this.shopName = shopName;
        this.shopID = shopID;
        this.longitude = longitude;
        this.latitude = latitude;
        this.foodName = foodName;
        this.foodID = foodID;
        this.foodPrice = foodPrice;
    }

    public String getShopName() {
        return shopName;
    }

    public String getFoodName() {
        return foodName;
    }


    public Double getFoodPrice() {
        return foodPrice;
    }

    public int getFoodID() {
        return foodID;
    }

    public int getShopID() {
        return shopID;
    }

    public String getLongitude() {
        return longitude;
    }


    public String getLatitude() {
        return latitude;
    }

}
