package com.javaquarium.business;

import com.javaquarium.beans.data.User;
import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.repository.PoissonUserRepository;
import com.javaquarium.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 21/02/2017.
 */
@Service
public class PoissonUserService implements IPoissonUserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private UserRepository userRepository;
    private PoissonUserRepository poissonUserRepository;

    public PoissonUserService(PoissonUserRepository poissonUserRepository,UserRepository userRepository) {
        this.poissonUserRepository = poissonUserRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserPoissonDO> getUserPoissons(String username) {
        logger.warn("Pram USER : " + userRepository.getClass().getSimpleName());
        User user = userRepository.findByusername(username);
        logger.warn("USER : " + user.getUsername());
        List<UserPoissonDO> lstUserPoissons = new ArrayList<>();
        lstUserPoissons = poissonUserRepository.findByUser(user);
        return lstUserPoissons;
    }

    @Override
    public void save(UserPoissonDO userPoissonDO) {
        poissonUserRepository.save(userPoissonDO);
    }

    @Transactional
    @Override
    public void save(List<UserPoissonDO> userPoissonDOList) {
        poissonUserRepository.save(userPoissonDOList);
    }

    @Override
    public void deleteUserPoisson(List<UserPoissonDO> userPoissonDOList) {
        poissonUserRepository.delete(userPoissonDOList);
    }

    @Override
    public void deleteUserPoisson(UserPoissonDO userPoissonDO) {
        poissonUserRepository.delete(userPoissonDO);
    }
}
