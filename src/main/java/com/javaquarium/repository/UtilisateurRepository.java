package com.javaquarium.repository;

import com.javaquarium.beans.data.UtilisateurDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by quentin on 20/02/2017.
 */
public interface UtilisateurRepository extends JpaRepository<UtilisateurDO, Integer> {

}
