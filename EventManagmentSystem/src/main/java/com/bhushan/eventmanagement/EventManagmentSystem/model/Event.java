package com.bhushan.eventmanagement.EventManagmentSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Integer event_Id;
    private String event_Name;
    private String location;
    private String event_Category;
    private Date event_Date;

    public Event()
    {

    }

    public Event(Integer event_Id,String event_Name,String location,String event_Category,Date event_Date)
    {
        this.setEvent_Id(event_Id);
        this.setEvent_Name(event_Name);
        this.setLocation(location);
        this.setEvent_Category(event_Category);
        this.setEvent_Date(event_Date);
    }

    public Integer getEvent_Id() {
        return event_Id;
    }

    public void setEvent_Id(Integer event_Id) {
        this.event_Id = event_Id;
    }

    public String getEvent_Name() {
        return event_Name;
    }

    public void setEvent_Name(String event_Name) {
        this.event_Name = event_Name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getEvent_Date() {
        return event_Date;
    }

    public void setEvent_Date(Date event_Date) {
        this.event_Date = event_Date;
    }

    public String getEvent_Category() {
        return event_Category;
    }

    public void setEvent_Category(String event_Category) {
        this.event_Category = event_Category;
    }
}
