package com.javaquarium.repository;

import com.javaquarium.beans.data.UtilisateurDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by quentin on 20/02/2017.
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurDO, Long> {
    UtilisateurDO findOneByUsername(String username);

}
