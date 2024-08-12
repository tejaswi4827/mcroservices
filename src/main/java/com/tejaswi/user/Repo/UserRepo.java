package com.tejaswi.user.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tejaswi.user.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

	User findByEmail(String email);

	@Query("DELETE FROM User u WHERE u.email = :email")
	void deleteByEmail( String email);
}
