package com.javaquarium.business;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.User;
import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.beans.web.UserPoissonVO;
import com.javaquarium.repository.PoissonUserRepository;
import com.javaquarium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 21/02/2017.
 */
public class PoissonUserService implements IPoissonUserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PoissonUserRepository poissonUserRepository;

    @Override
    public List<UserPoissonDO> getUserPoissons(String username) {
        User user = userRepository.findByusername(username);
        List<UserPoissonDO> lstUserPoissons = new ArrayList<>();
        lstUserPoissons = poissonUserRepository.findByUser(user);
        return lstUserPoissons;
    }

    @Override
    public void save(UserPoissonVO userPoissonVO) {
        //poissonUserRepository.save(userPoissonDO);

    }
}
