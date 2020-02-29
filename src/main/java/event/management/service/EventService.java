package event.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import event.management.beans.Event;
import event.management.dao.EventDao;

@Service
public class EventService {

	@Autowired
	EventDao eventManagementDao;

	public List<Event> getEvents() {
		List<Event> events = eventManagementDao.getEvents();
		return events;
	}

	public boolean addEvent(Event event) {
		boolean isUpdated = eventManagementDao.addEvent(event);
		return isUpdated;
	}

}
