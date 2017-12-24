package springmvc_example.service;

import java.util.List;
import org.springframework.stereotype.Service;
import springmvc_example.model.User;

public interface UserService {
	public List<User> getListUser();
	public void saveOrUpdate(User user);
	public void deleteUser(int id);
	public User findUserById(int id);
}