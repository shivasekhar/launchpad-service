package event.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import event.management.beans.User;
import event.management.dao.UserDao;

@Service
public class UserService {
	
	@Autowired
	UserDao userDao;

	public boolean addUser(User user) {
		boolean isUpdated = userDao.addUser(user);
		return isUpdated;
	}

}
