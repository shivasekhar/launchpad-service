package event.management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import event.management.beans.User;

@Repository
public class UserDao {

	Connection connection;

	public UserDao() throws Exception {
		this.connection = MysqlConfig.getConnection();
	}

	public boolean addUser(User user) {
		try {
			String insertUserQuery = "insert into users(event_id, first_name, last_name, register_no, "
					+ "department, email) values(?,?,?,?,?,?)";
			PreparedStatement addUserStatement = connection.prepareStatement(insertUserQuery);
			addUserStatement.setInt(1, user.getEventId());
			addUserStatement.setString(2, user.getFirstName());
			addUserStatement.setString(3, user.getLastName());
			addUserStatement.setString(4, user.getRegisterNo());
			addUserStatement.setString(5, user.getDepartment());
			addUserStatement.setString(6, user.getEmail());
			return addUserStatement.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
