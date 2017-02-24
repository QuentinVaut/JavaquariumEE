package com.javaquarium.repository;

import com.javaquarium.beans.data.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by quentin on 21/02/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<UserDO, Long> {

    /**
     * @param username
     * @return userdo object
     */
    UserDO findByusername(String username);
}
