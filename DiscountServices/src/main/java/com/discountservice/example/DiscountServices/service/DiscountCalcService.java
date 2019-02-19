package com.discountservice.example.DiscountServices.service;

import com.discountservice.example.DiscountServices.model.Discount;


import java.util.List;

public interface DiscountCalcService {


   public List<Discount> getDiscountForStandardUser(Integer amount);

   public Boolean saveDiscount(Discount discount);

   List<Discount> findListOfDiscApplied(String userType, Integer amount);

   public Discount findListofDisctowithinRange( String userType,  Integer amount);

   public Integer applyDiscount(List<Discount> discountsList,Integer amount);
}
