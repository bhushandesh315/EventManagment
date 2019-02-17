package com.bhushan.eventmanagement.EventManagmentSystem;

import com.bhushan.eventmanagement.EventManagmentSystem.dao.EventRepository;
import com.bhushan.eventmanagement.EventManagmentSystem.daoImpl.EventDao;
import com.bhushan.eventmanagement.EventManagmentSystem.enums.Event_Category;
import com.bhushan.eventmanagement.EventManagmentSystem.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication
public class EventManagmentSystemApplication {

    @Autowired
   static EventRepository eventDao;

	public static void main(String[] args) {
		SpringApplication.run(EventManagmentSystemApplication.class, args);

	}

}

