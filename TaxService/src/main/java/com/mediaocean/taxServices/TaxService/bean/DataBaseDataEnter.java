package com.mediaocean.taxServices.TaxService.bean;

import com.mediaocean.taxServices.TaxService.dao.TaxRepository;
import com.mediaocean.taxServices.TaxService.model.Tax;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

@Component
public class DataBaseDataEnter implements CommandLineRunner {

    @Autowired
    public TaxRepository taxRepository;

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {


        String fileName = "src/main/resources/TaxBar.csv";

        FileInputStream fis = new FileInputStream(new File(fileName));
        CSVReader reader = new CSVReader(new InputStreamReader(fis));
        String[] nextLine;
        //reader.readNext();


            while ((nextLine = reader.readNext()) != null) {

                Tax tax = new Tax();
                tax.setTax_Category(nextLine[0]);
                tax.setTax_Percentage(Integer.valueOf(nextLine[1]));
                taxRepository.save(tax);

            }
        }

       // System.out.println(discountRepo.findAll().size());
        //return discountList;

    }

