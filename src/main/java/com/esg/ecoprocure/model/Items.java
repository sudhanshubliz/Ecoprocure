package com.esg.ecoprocure.model;

import lombok.Data;

@Data
public class Items {

        private String product_uid;
        private String product_type;
        private String name;
        private String full_url;



    public String getProduct_uid() {
        return product_uid;
    }

    public void setProduct_uid(String product_uid) {
        this.product_uid = product_uid;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull_url() {
        return full_url;
    }

    public void setFull_url(String full_url) {
        this.full_url = full_url;
    }

}
