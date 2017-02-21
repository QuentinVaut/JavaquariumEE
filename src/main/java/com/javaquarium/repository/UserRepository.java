package com.javaquarium.repository;

import com.javaquarium.beans.data.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by quentin on 21/02/2017.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
    User findByusername(String username);
}
