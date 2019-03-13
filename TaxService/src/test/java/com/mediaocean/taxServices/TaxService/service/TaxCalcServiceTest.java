package com.mediaocean.taxServices.TaxService.service;

import com.mediaocean.taxServices.TaxService.model.Invoice;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaxCalcServiceTest {

    @Autowired
    TaxCalcService taxCalcService;

    List<Invoice> tax_List;

    @Before
    public void intialisedTax()
    {
        tax_List= new ArrayList<>();
        Invoice invoice = new Invoice();
        invoice.setCategory("A");
        invoice.setAmount(100);
        Invoice invoice1 = new Invoice();
        invoice1.setCategory("B");
        invoice1.setAmount(200);
        Invoice invoice2 = new Invoice();
        invoice2.setCategory("C");
        invoice2.setAmount(300);
        Invoice invoice3 = new Invoice();
        invoice3.setCategory("A");
        invoice3.setAmount(400);

        tax_List.add(invoice1);
        tax_List.add(invoice2);
        tax_List.add(invoice3);
        tax_List.add(invoice);
    }

    @Test
    public void findTaxPercByCategory() {

        Integer fianlAmount=0;
        for (Invoice invoice:
             tax_List) {

            Integer category_Percent=taxCalcService.findTaxPercByCategory(invoice.getCategory());
           Integer totalAmount = taxCalcService.calcTaxPlusAmount(category_Percent,invoice.getAmount());
           fianlAmount+=totalAmount;
        }

        System.out.println("Final Amount after calculation of Tax is " +fianlAmount);
    }
}

