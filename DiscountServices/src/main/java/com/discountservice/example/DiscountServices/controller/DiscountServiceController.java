package com.discountservice.example.DiscountServices.controller;

import com.discountservice.example.DiscountServices.DiscountDao.DiscountRepo;
import com.discountservice.example.DiscountServices.ServiceImpl.DiscountServCalcImpl;
import com.discountservice.example.DiscountServices.model.Discount;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class DiscountServiceController {

    List<Discount> discountList=new ArrayList<>();

    @Autowired
    DiscountRepo discountRepo;

    @Autowired
    DiscountServCalcImpl discountServCalc;

    @GetMapping("/")
    public List<Discount> saveDiscountList() throws FileNotFoundException, IOException {
        String fileName = "src/main/resources/Discount.csv";

        FileInputStream fis = new FileInputStream(new File(fileName));
        CSVReader reader = new CSVReader(new InputStreamReader(fis));
        String[] nextLine;
        //reader.readNext();

        if(discountRepo.findAll().size()<7) {
            while ((nextLine = reader.readNext()) != null) {

                Discount discount = new Discount();
                discount.setUserType(nextLine[0]);
                discount.setStart(Integer.valueOf(nextLine[1]));
                discount.setEnd(Integer.valueOf(nextLine[2]));
                discount.setDiscountPerc(Integer.valueOf(nextLine[3]));
                discountList.add(discount);
                discountServCalc.saveDiscount(discount);
            }
        }

        System.out.println(discountRepo.findAll().size());
        return discountList;
    }


    @GetMapping("/{userType}/{amount}")
    public String getDiscountAmount(@PathVariable("userType") String userType,@PathVariable("amount") Integer amount)
    {
        Integer finalDiscountAmount=0;
        List<Discount> discountsList;
        Discount discount;
        Integer discountedAmount=0;
        discountsList=discountServCalc.findListOfDiscApplied(userType,amount);
        discount=discountServCalc.findListofDisctowithinRange(userType,amount);

        if(!discountsList.isEmpty() && discount!=null)
        {
             finalDiscountAmount = discountServCalc.applyDiscount(discountsList, amount);
             return "Discounted amount "+amount+" is for RS "+finalDiscountAmount;
        }

        


        System.out.println(finalDiscountAmount);

        return "No Range for Discount";
    }
}
