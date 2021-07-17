package springTutorial.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springTutorial.northwind.business.abstracts.UserService;
import springTutorial.northwind.core.dataAccess.UserDao;
import springTutorial.northwind.core.entities.User;
import springTutorial.northwind.core.utilities.results.DataResult;
import springTutorial.northwind.core.utilities.results.Result;
import springTutorial.northwind.core.utilities.results.SuccessDataResult;
import springTutorial.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {
	
	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı Eklendi");
	}

	@Override
	public DataResult<User> findByEmial(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmial(email),"Kullanıcı bulundu.");
	}

}
