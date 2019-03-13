package com.mediaocean.taxServices.TaxService.controller;


import com.mediaocean.taxServices.TaxService.dao.TaxRepository;
import com.mediaocean.taxServices.TaxService.model.Invoice;
import com.mediaocean.taxServices.TaxService.model.Tax;
import com.mediaocean.taxServices.TaxService.service.TaxCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("/taxService")
public class TaxCalcController {

    @Autowired
    TaxRepository taxRepository;

    @Autowired
    TaxCalcService taxCalcService;


    @GetMapping("/")
    public List<Tax> getListTaxBar() {
        return taxRepository.findAll();
    }


    @PostMapping("/invoice")
    public String getTaxReceipt(@RequestBody List<Invoice> invoice) {

        String sb="";
        Integer totalAmount=0;
        for (Invoice invoice1 : invoice) {
            Integer taxPerc = taxCalcService.findTaxPercByCategory(invoice1.getCategory());
            Integer final_Amount = null;

            if (!(taxPerc == null)) {

                final_Amount = taxCalcService.calcTaxPlusAmount(taxPerc, invoice1.getAmount());
               sb+= "For Category :" + invoice1.getCategory() +
                        " percentage of tax applied :" + taxPerc +
                        "% Total Amount by applying tax on " + invoice1.getAmount() + " is " +
                        String.valueOf(final_Amount)+"\r\n";

                totalAmount+=final_Amount;


            }
        }

        return sb+ "Total Bill Amount is :: "+totalAmount;
    }
}