package com.javaquarium.business;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.repository.PoissonUserRepository;
import com.javaquarium.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

    public PoissonUserService(PoissonUserRepository poissonUserRepository, UserRepository userRepository) {
        this.poissonUserRepository = poissonUserRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<UserPoissonDO> getUserPoissons(String username) {
        UserDO user = userRepository.findByusername(username);
        List<UserPoissonDO> lstUserPoissons = new ArrayList<>();
        lstUserPoissons = poissonUserRepository.findByUser(user);
        return lstUserPoissons;
    }

    @Override
    public void save(UserPoissonDO userPoissonDO) {
        poissonUserRepository.save(userPoissonDO);
    }

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
