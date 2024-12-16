package com.esg.ecoprocure.model;

import lombok.Data;

@Data
public class Price {

    private String product_uid;
    private float unit_price;
    private String unit_price_measure;
    private float unit_price_measure_amount;

    public String getProduct_uid() {
        return product_uid;
    }

    public void setProduct_uid(String product_uid) {
        this.product_uid = product_uid;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public String getUnit_price_measure() {
        return unit_price_measure;
    }

    public void setUnit_price_measure(String unit_price_measure) {
        this.unit_price_measure = unit_price_measure;
    }

    public float getUnit_price_measure_amount() {
        return unit_price_measure_amount;
    }

    public void setUnit_price_measure_amount(float unit_price_measure_amount) {
        this.unit_price_measure_amount = unit_price_measure_amount;
    }
}
