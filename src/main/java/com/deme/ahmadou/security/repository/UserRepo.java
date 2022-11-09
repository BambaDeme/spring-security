package com.deme.ahmadou.security.repository;

import com.deme.ahmadou.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findUserByUsername(String username);

}
