package com.bhushan.eventmanagement.EventManagmentSystem.controller;

import com.bhushan.eventmanagement.EventManagmentSystem.dao.EventRepository;
import com.bhushan.eventmanagement.EventManagmentSystem.daoImpl.EventDao;
import com.bhushan.eventmanagement.EventManagmentSystem.enums.Event_Category;
import com.bhushan.eventmanagement.EventManagmentSystem.model.Event;
import com.bhushan.eventmanagement.EventManagmentSystem.service.EventService;
import com.bhushan.eventmanagement.EventManagmentSystem.serviceImpl.EventServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/Event")
public class EventMangmentController {

    @Autowired
    EventRepository eventDao;

    @Autowired
    EventServiceImpl eventServiceImpl;





    @ApiOperation(value="get all event list by category and location",response=Event.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Get all events by category",response=Event.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Event not found")
    })
    @RequestMapping(value = "/getEventByCategory", method = RequestMethod.GET)
    public ModelAndView saveEmployee(@RequestParam(value="category") String category, @RequestParam(value="location") String location) {
        Map<String, Object> model = new HashMap<String, Object>();

        List<Event> event = eventServiceImpl.listOfEventCategoryandLoca(category,location);
        if(!event.isEmpty()) {
            model.put("events", event);
            return new ModelAndView("add", model);
        }
        return new ModelAndView("error");
    }





    @ApiOperation(value="get all event list",response=Event.class)
    @ApiResponses(value={
            @ApiResponse(code=200,message="Get all events",response=Event.class),
            @ApiResponse(code=500,message="Internal Server Error"),
            @ApiResponse(code=404,message="Event not found")
    })
    @RequestMapping (value="/allEvents", method = RequestMethod.GET)
    public String modelAndView(Map<String, Object> model)
    {
        //Music Events
        Event event_Music_Classical = new Event(1,"Classical Music","India", Event_Category.MUSIC.name(), new Date());
        Event event_Music_Rock = new Event(2,"Rock Music","London", Event_Category.MUSIC.name(), new GregorianCalendar(2019, Calendar.FEBRUARY, 11).getTime());
        Event event_Music_Pop = new Event(3,"Pop Music","London", Event_Category.MUSIC.name(), new GregorianCalendar(2019, Calendar.FEBRUARY, 17).getTime());
        Event event_Music_DJ = new Event(4,"DJ Music","India", Event_Category.MUSIC.name(), new GregorianCalendar(2019, Calendar.MAY, 11).getTime());

        eventServiceImpl.save(event_Music_Classical);
        eventServiceImpl.save(event_Music_Rock);
        eventServiceImpl.save(event_Music_Pop);
        eventServiceImpl.save(event_Music_DJ);
        //Music Events
        Event blood_Donation_Student = new Event(5,"Stundent Blood donation","India", Event_Category.BLOOD_DONATION.name(), new GregorianCalendar(2019, Calendar.MARCH, 13).getTime());
        Event blood_Donation_Army = new Event(6,"Army Blood donation","London", Event_Category.BLOOD_DONATION.name(), new GregorianCalendar(2019, Calendar.APRIL, 04).getTime());
        Event blood_Donation_Orphan = new Event(7,"Orphan house Blood donation","London", Event_Category.BLOOD_DONATION.name(), new GregorianCalendar(2019, Calendar.JULY, 04).getTime());

        eventServiceImpl.save(blood_Donation_Student);
        eventServiceImpl.save(blood_Donation_Army);
        eventServiceImpl.save(blood_Donation_Orphan);

        model.put("events", eventDao.findAll());
        return "welcome";

    }



}
