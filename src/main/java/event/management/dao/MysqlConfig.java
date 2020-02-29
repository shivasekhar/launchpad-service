package event.management.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import event.management.constants.ApplicationConstants;

public class MysqlConfig {
	
	public static Connection getConnection() throws Exception {
		Class.forName(ApplicationConstants.DRIVER_NAME);
		Connection connection = DriverManager.getConnection(ApplicationConstants.MYSQL_HOSTNAME,
				ApplicationConstants.MYSQL_USERNAME, ApplicationConstants.MYSQL_PASSWORD);
		return connection;
	}

}
