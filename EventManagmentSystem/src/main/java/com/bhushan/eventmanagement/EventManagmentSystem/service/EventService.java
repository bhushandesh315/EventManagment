package com.bhushan.eventmanagement.EventManagmentSystem.service;

import com.bhushan.eventmanagement.EventManagmentSystem.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    public List<Event> getAllEvent();

    public String save(Event event);

    public List<Event> listOfEventCategoryandLoca(String category,String location);

    public Optional<Event> getEventById(Integer id);
}
