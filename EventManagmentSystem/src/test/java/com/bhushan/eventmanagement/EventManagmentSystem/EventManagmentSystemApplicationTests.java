package com.bhushan.eventmanagement.EventManagmentSystem;

import com.bhushan.eventmanagement.EventManagmentSystem.enums.Event_Category;
import com.bhushan.eventmanagement.EventManagmentSystem.model.Event;
import com.bhushan.eventmanagement.EventManagmentSystem.serviceImpl.EventServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class EventManagmentSystemApplicationTests {

	@Autowired
	EventServiceImpl eventServiceImpl;

	@Before
	public void setEvent()
	{
		Event event_Music_Classical = new Event(15,"Classical Music","India", Event_Category.MUSIC.name(), new Date());
		eventServiceImpl.save(event_Music_Classical);
	}
	//This test is for to check data inserted in table or not
	@Test
	public void getEventWithId() throws Exception {

	Optional<Event> event = eventServiceImpl.getEventById(15);

	if(event==null) {
		throw new Exception();
	}

	}


	//This test for music event in india
	@Test
	public void getEventByCategoryMusic() throws Exception {

		List<Event> event = eventServiceImpl.listOfEventCategoryandLoca("MUSIC","India");

		if(event.isEmpty()) {
			throw new Exception();
		}
}

	//This test for music event in London
	//As there is no record for london in table it is failed
	@Test
	public void getEventByCategoryMusic_london() throws Exception {

		List<Event> event = eventServiceImpl.listOfEventCategoryandLoca("MUSIC","London");

		if(event.isEmpty()) {
			throw new Exception();
		}
	}
}

