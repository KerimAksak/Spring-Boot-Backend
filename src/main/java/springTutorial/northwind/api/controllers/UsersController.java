package springTutorial.northwind.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springTutorial.northwind.business.abstracts.UserService;
import springTutorial.northwind.core.entities.User;

@RestController
@RequestMapping(value = "/api/users")
public class UsersController {
	
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	// HTTP response status codes
	// (?) Success or Error 
	@RequestMapping(value = "/add")
	public ResponseEntity<?> add(@RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	

}