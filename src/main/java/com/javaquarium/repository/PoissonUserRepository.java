package com.javaquarium.repository;

import com.javaquarium.beans.data.Role;
import com.javaquarium.beans.data.User;
import com.javaquarium.beans.data.UserPoissonDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by quentin on 21/02/2017.
 */
public interface PoissonUserRepository extends JpaRepository<UserPoissonDO, Integer> {
    List<UserPoissonDO> findByUser(User user);
}
