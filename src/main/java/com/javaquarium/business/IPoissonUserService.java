package com.javaquarium.business;

import com.javaquarium.beans.data.UserPoissonDO;

import java.util.List;

/**
 * Created by quentin on 21/02/2017.
 */
public interface IPoissonUserService {

    List<UserPoissonDO> getUserPoissons(String username);

    void save(UserPoissonDO userPoissonDO);
    void save(List<UserPoissonDO> userPoissonDOList);
    void deleteUserPoisson(List<UserPoissonDO> userPoissonDOList);
    void deleteUserPoisson(UserPoissonDO userPoissonDO);
}
