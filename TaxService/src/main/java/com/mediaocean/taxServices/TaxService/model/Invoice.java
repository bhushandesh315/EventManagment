package com.mediaocean.taxServices.TaxService.model;

import java.io.Serializable;
import java.security.SecureRandom;

public class Invoice implements Serializable {


    private Integer amount;

    private String category;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
