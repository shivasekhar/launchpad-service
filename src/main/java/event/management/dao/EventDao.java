package event.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import event.management.beans.Event;

@Repository
public class EventDao {

	Connection connection;

	public EventDao() throws Exception {
		this.connection = MysqlConfig.getConnection();
	}

	public boolean addEvent(Event event) {
		try {
			String addEventQuery = "insert into events(name, type, venue, date) values(?,?,?,?)";
			PreparedStatement addEventStatement = connection.prepareStatement(addEventQuery);
			addEventStatement.setString(1, event.getName());
			addEventStatement.setString(2, event.getType());
			addEventStatement.setString(3, event.getVenue());
			addEventStatement.setString(4, event.getDate());
			return addEventStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Event> getEvents() {
		List<Event> events = new ArrayList<>();
		try {
			String getEventsQuery = "select * from events";
			Statement getEventsStatement = connection.createStatement();
			ResultSet resultSet = getEventsStatement.executeQuery(getEventsQuery);
			while (resultSet.next()) {
				Event event = new Event();
				event.setId(resultSet.getInt("id"));
				event.setName(resultSet.getString("name"));
				event.setType(resultSet.getString("type"));
				event.setVenue(resultSet.getString("venue"));
				event.setDate(resultSet.getString("date"));
				events.add(event);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return events;
	}

}
