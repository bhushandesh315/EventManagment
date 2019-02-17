package com.bhushan.eventmanagement.EventManagmentSystem.enums;

public enum Event_Category {

    MUSIC("1"),

    /** The REGISTERED Status. */
    PLAY("2"),

    /** The ALLOCATED Status. */
    BLOOD_DONATION("3");


    private String categoryCode;

    /**
     * Instantiates a new event management enum.
     *
     * @param categoryCode the status code
     */
    Event_Category(String categoryCode){
        this.categoryCode=categoryCode;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    String getValue(){
        return this.name();
    }

}
