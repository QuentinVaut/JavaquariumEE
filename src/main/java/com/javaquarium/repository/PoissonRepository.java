package com.javaquarium.repository;

import com.javaquarium.beans.data.PoissonDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PoissonRepository extends JpaRepository<PoissonDO, Integer> {

}
