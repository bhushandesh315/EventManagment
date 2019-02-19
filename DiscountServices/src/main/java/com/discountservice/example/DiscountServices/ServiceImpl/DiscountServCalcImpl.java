package com.discountservice.example.DiscountServices.ServiceImpl;

import com.discountservice.example.DiscountServices.DiscountDao.DiscountRepo;
import com.discountservice.example.DiscountServices.model.Discount;
import com.discountservice.example.DiscountServices.service.DiscountCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiscountServCalcImpl implements DiscountCalcService {

    @Autowired
    DiscountRepo discountRepo;

    @Override
    public List<Discount> getDiscountForStandardUser(Integer amount) {


        return new ArrayList<>();
    }

    @Override
    public Boolean saveDiscount(Discount discount) {

        discountRepo.save(discount);

        return true;
    }



    @Override
    public Discount findListofDisctowithinRange(String userType, Integer amount) {
        return discountRepo.findListofDisctowithinRange(userType,amount);
    }

    @Override
    public Integer applyDiscount(List<Discount> discountsList,Integer amount) {

        Integer discountedAmount=0;
        for (int i=0;i<discountsList.size()-1;i++)
        {
            Integer startAmount = discountsList.get(i).getStart();
            Integer endAmount = discountsList.get(i).getEnd();
            Integer discountAmountSub=endAmount-startAmount;
            Integer discountOnAmount=(discountAmountSub*discountsList.get(i).getDiscountPerc()/100);
            discountedAmount=discountedAmount+discountOnAmount;

        }

        Integer discountAmountForRange= amount-discountsList.get(discountsList.size()-1).getStart();
        if(discountAmountForRange!=null & discountAmountForRange!=0)
        {
            Integer discountOnAmount=(discountAmountForRange*discountsList.get(discountsList.size()-1).getDiscountPerc()/100);
            discountedAmount=discountedAmount+discountOnAmount;
        }

        Integer finalDiscountedAmount=amount-discountedAmount;

        return finalDiscountedAmount;

    }

    @Override
    public List<Discount> findListOfDiscApplied(String userType, Integer amount) {
        return discountRepo.findListOfDiscApplied(userType,amount);
    }


}
