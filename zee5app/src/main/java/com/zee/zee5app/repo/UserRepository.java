package com.zee.zee5app.repo;

//import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	boolean existsByEmail(String email);
	boolean existsByuserName(String username );
	Optional<User> findByuserName(String username);

}
