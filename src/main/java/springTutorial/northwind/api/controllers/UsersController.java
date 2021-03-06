package springTutorial.northwind.api.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import springTutorial.northwind.business.abstracts.UserService;
import springTutorial.northwind.core.entities.User;
import springTutorial.northwind.core.utilities.results.ErrorDataResult;

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
	// @Valid; Test validation
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user));
	}
	
	// Global Exception Handler
	// AOP; Aspecte Oriented Programming
	@ExceptionHandler(MethodArgumentNotValidException.class)
	// Default return BAD_REQUEST
	@ResponseStatus(HttpStatus.BAD_REQUEST) 
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors, "HATA!");
		return errors;
	}
	
	
	

}
