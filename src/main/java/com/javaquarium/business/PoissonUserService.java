package com.javaquarium.business;

import com.javaquarium.beans.data.UserDO;
import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.repository.PoissonUserRepository;
import com.javaquarium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 21/02/2017.
 */
@Service
public class PoissonUserService implements IPoissonUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PoissonUserRepository poissonUserRepository;

    /**
     * @param username
     * @return list of userpoissondo
     */
    @Override
    public List<UserPoissonDO> getUserPoissons(String username) {
        UserDO user = userRepository.findByusername(username);
        List<UserPoissonDO> lstUserPoissons;
        lstUserPoissons = poissonUserRepository.findByUser(user);
        return lstUserPoissons;
    }

    /**
     * @param userPoissonDO
     */
    @Override
    public void save(UserPoissonDO userPoissonDO) {
        poissonUserRepository.save(userPoissonDO);
    }

    /**
     * @param userPoissonDOList
     */
    @Override
    public void save(List<UserPoissonDO> userPoissonDOList) {
        poissonUserRepository.save(userPoissonDOList);
    }

    /**
     * @param userPoissonDOList
     */
    @Override
    public void deleteUserPoisson(List<UserPoissonDO> userPoissonDOList) {
        poissonUserRepository.delete(userPoissonDOList);
    }

    /**
     * @param userPoissonDO
     */
    @Override
    public void deleteUserPoisson(UserPoissonDO userPoissonDO) {
        poissonUserRepository.delete(userPoissonDO);
    }
}
