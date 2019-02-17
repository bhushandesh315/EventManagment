package com.bhushan.eventmanagement.EventManagmentSystem.dao;

import com.bhushan.eventmanagement.EventManagmentSystem.enums.Event_Category;
import com.bhushan.eventmanagement.EventManagmentSystem.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {


    @Query("select e from Event e where e.event_Category = :event_Category and e.location=:location ")
    List<Event> findByEventCategory(@Param("event_Category") String event_Category,@Param("location") String location);
}
