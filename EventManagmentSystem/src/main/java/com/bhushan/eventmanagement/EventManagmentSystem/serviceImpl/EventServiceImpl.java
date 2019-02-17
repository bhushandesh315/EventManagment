package com.bhushan.eventmanagement.EventManagmentSystem.serviceImpl;

import com.bhushan.eventmanagement.EventManagmentSystem.dao.EventRepository;
import com.bhushan.eventmanagement.EventManagmentSystem.model.Event;
import com.bhushan.eventmanagement.EventManagmentSystem.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {
    @Autowired
    EventRepository eventRepository;

    @Override
    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    @Override
    public String save(Event event) {
        eventRepository.save(event);
        return "Event with id "+event.getEvent_Id()+" added successfully";
    }

    @Override
    public List<Event> listOfEventCategoryandLoca(String category, String location) {
        return eventRepository.findByEventCategory(category,location);
    }

    @Override
    public Optional<Event> getEventById(Integer id)
    {
        return eventRepository.findById(id);
    }
}
