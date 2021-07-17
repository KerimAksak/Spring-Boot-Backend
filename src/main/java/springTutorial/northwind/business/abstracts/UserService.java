package springTutorial.northwind.business.abstracts;

import springTutorial.northwind.core.entities.User;
import springTutorial.northwind.core.utilities.results.DataResult;
import springTutorial.northwind.core.utilities.results.Result;

public interface UserService {
	
	Result add(User user);
	
	DataResult<User> findByEmial(String email);

}
