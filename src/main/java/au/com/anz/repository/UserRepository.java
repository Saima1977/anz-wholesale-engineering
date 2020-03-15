package au.com.anz.repository;

import au.com.anz.dao.UserDAO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDAO, Long> {
}