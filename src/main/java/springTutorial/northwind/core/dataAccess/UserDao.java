package springTutorial.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import springTutorial.northwind.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {
	User findByEmial(String email);
}