package com.cyntex.TourismApp.Beans;

import java.util.List;

public class ShopDetailsResponseBean extends BaseResponse {
    private List<ShopDetailsBean> shopDetails;

    public List<ShopDetailsBean> getShopDetails() {
        return shopDetails;
    }

    public void setShopDetails(List<ShopDetailsBean> shopDetails) {
        this.shopDetails = shopDetails;
    }
}
