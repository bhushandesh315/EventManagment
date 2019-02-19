package com.discountservice.example.DiscountServices.DiscountDao;

import com.discountservice.example.DiscountServices.model.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiscountRepo extends JpaRepository<Discount,Integer> {

    @Query("select d from Discount d where d.userType = :userType and d.start<:amount ")
    List<Discount> findListOfDiscApplied(@Param("userType") String userType, @Param("amount") Integer amount);


    @Query("select d from Discount d where d.userType = :userType and d.start<=:amount and d.end>=:amount ")
    public Discount findListofDisctowithinRange(@Param("userType") String userType,@Param("amount")Integer amount);


}
