package com.discountservice.example.DiscountServices;

import com.discountservice.example.DiscountServices.DiscountDao.DiscountRepo;
import com.discountservice.example.DiscountServices.ServiceImpl.DiscountServCalcImpl;
import com.discountservice.example.DiscountServices.model.Discount;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;

@SpringBootApplication
public class DiscountServicesApplication {


	public static void main(String[] args) throws IOException, FileNotFoundException {
		SpringApplication.run(DiscountServicesApplication.class, args);


	}

}
