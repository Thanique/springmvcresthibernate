package springmvc_example.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc_example.dao.UserDao;
import springmvc_example.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	UserDao userDao;
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getListUser() {
		return userDao.getListUser();
	}

	@Override
	public void saveOrUpdate(User user) {
		System.out.println("SERVICE : " + user);
		userDao.saveOrUpdate(user);
	}

	@Override
	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}

	@Override
	public User findUserById(int id) {
		return userDao.findUserById(id);
	}
}