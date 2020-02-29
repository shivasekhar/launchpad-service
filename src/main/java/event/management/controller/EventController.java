package event.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import event.management.beans.Event;
import event.management.service.EventService;

@CrossOrigin
@RestController
@RequestMapping("/events")
public class EventController {

	@Autowired
	EventService eventManagementService;

	@GetMapping
	public List<Event> getEvents() {
		List<Event> events = eventManagementService.getEvents();
		return events;
	}

	@PostMapping
	public boolean addEvent(@RequestBody Event event) {
		boolean isUpdated = eventManagementService.addEvent(event);
		return isUpdated;
	}
}
