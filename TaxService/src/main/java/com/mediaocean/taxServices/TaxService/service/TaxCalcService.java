package com.mediaocean.taxServices.TaxService.service;


import com.mediaocean.taxServices.TaxService.dao.TaxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaxCalcService {

    @Autowired
    TaxRepository taxRepository;

    public Integer findTaxPercByCategory(String category)
    {
        return taxRepository.findListOfDiscApplied(category);
    }


    public Integer calcTaxPlusAmount(Integer taxPerc, Integer amount) {

        Integer final_Amount=null;

        Integer percentageAmount= (amount*taxPerc/100);
        final_Amount=amount+percentageAmount;

        return final_Amount;
    }
}
