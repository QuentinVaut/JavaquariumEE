package com.javaquarium.repository;

import com.javaquarium.beans.data.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by quentin on 21/02/2017.
 */
@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<RoleDO, Integer> {

    /**
     * @param role
     * @return roledo object
     */
    RoleDO findByRole(String role);
}