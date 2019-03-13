package com.mediaocean.taxServices.TaxService.dao;

import com.mediaocean.taxServices.TaxService.model.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxRepository extends JpaRepository<Tax,Integer> {


    @Query("select t.tax_Percentage from Tax t where t.tax_Category = :tax_Category")
     public Integer findListOfDiscApplied(@Param("tax_Category") String tax_Category);

}
