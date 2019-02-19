package com.discountservice.example.DiscountServices;

import com.discountservice.example.DiscountServices.DiscountDao.DiscountRepo;
import com.discountservice.example.DiscountServices.ServiceImpl.DiscountServCalcImpl;
import com.discountservice.example.DiscountServices.controller.DiscountServiceController;
import com.discountservice.example.DiscountServices.model.Discount;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountServicesApplicationTests {

	@Autowired
	DiscountServiceController discountServiceController;

	@Autowired
	DiscountServCalcImpl discountServCalc;

	@Autowired
	DiscountRepo discountRepo;

	@Before
	public void loadAllDiscountInDb() throws IOException, FileNotFoundException {
		//discountRepo.f
		discountServiceController.saveDiscountList();
	}

	@Test
	public void discountForStandardevent()
	{
		String s="1500,3550,5500";
		String [] amountList=s.split(",");
		for (String amountItr:amountList) {

			String userType="Standard";
			Integer amount=Integer.valueOf(amountItr);
			List<Discount> discountsList=discountServCalc.findListOfDiscApplied(userType,amount);
			Discount discount=discountServCalc.findListofDisctowithinRange(userType,amount);
			Integer discountApplied=discountServCalc.applyDiscount(discountsList,amount);

			System.out.println("Discount got on amount "+amount+" is RS "+discountApplied);
		}

	}


	@Test
	public void discountForPremiumEvent()
	{
		String s="1500,3550,5500";
		String userType="Premium";
		String [] amountList=s.split(",");
		for (String amountItr:amountList) {


			Integer amount=Integer.valueOf(amountItr);
			List<Discount> discountsList=discountServCalc.findListOfDiscApplied(userType,amount);
			//Discount discount=discountServCalc.findListofDisctowithinRange(userType,amount);
			Integer discountApplied=discountServCalc.applyDiscount(discountsList,amount);

			System.out.println("Discount got on amount "+amount+" is RS "+discountApplied);
		}

	}

}
