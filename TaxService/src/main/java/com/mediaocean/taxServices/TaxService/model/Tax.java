package com.mediaocean.taxServices.TaxService.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tax {

    @Id
    @GeneratedValue
    private Integer tax_Id;
    private String tax_Category;
    private Integer tax_Percentage;

    public Integer getTax_Id() {
        return tax_Id;
    }

    public void setTax_Id(Integer tax_Id) {
        this.tax_Id = tax_Id;
    }

    public String getTax_Category() {
        return tax_Category;
    }

    public void setTax_Category(String tax_Category) {
        this.tax_Category = tax_Category;
    }

    public Integer getTax_Percentage() {
        return tax_Percentage;
    }

    public void setTax_Percentage(Integer tax_Percentage) {
        this.tax_Percentage = tax_Percentage;
    }
}
