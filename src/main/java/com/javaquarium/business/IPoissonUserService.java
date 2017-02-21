package com.javaquarium.business;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.beans.web.UserPoissonVO;

import java.util.List;

/**
 * Created by quentin on 21/02/2017.
 */
public interface IPoissonUserService {

    List<UserPoissonDO> getUserPoissons(String username);

    void save(UserPoissonVO userPoissonVO);

}
