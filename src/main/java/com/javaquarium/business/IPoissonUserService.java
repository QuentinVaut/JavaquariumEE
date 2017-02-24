package com.javaquarium.business;

import com.javaquarium.beans.data.UserPoissonDO;

import java.util.List;

/**
 * Created by quentin on 21/02/2017.
 */
public interface IPoissonUserService {

    /**
     * @param username
     * @return the list of UserPoissonDO
     */
    List<UserPoissonDO> getUserPoissons(String username);

    /**
     * @param userPoissonDO
     */
    void save(UserPoissonDO userPoissonDO);

    /**
     * @param userPoissonDOList
     */
    void save(List<UserPoissonDO> userPoissonDOList);

    /**
     * @param userPoissonDOList
     */
    void deleteUserPoisson(List<UserPoissonDO> userPoissonDOList);

    /**
     * @param userPoissonDO
     */
    void deleteUserPoisson(UserPoissonDO userPoissonDO);
}
