package springmvc_example.contoller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springmvc_example.model.User;
import springmvc_example.service.UserService;

@RestController
public class UserController {	
	@Autowired
	UserService userService;

	@RequestMapping(value="/user", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<User> getListUser()	{
		System.out.println("TEST1");
		
		return (List<User>) userService.getListUser();
	}

	@RequestMapping(value="/user", method=RequestMethod.POST)
	public ResponseEntity<Boolean> add(@RequestBody User user)	{
		System.out.println("CONTROLLER1 : " + user);
		userService.saveOrUpdate(user);
		
		return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);	
	}

	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Boolean> update(@PathVariable("id") int id, @RequestBody User user){
		user.setId(id);
		userService.saveOrUpdate(user);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);	
	}

	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
		User user = userService.findUserById(id);
		userService.deleteUser(id);
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);	
	}
}