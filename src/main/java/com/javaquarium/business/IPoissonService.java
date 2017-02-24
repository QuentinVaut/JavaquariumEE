package com.javaquarium.business;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;

import java.util.List;

/**
 * Created by quentin on 16/02/2017.
 */

public interface IPoissonService {

    /**
     * @return list of all registred poisson
     */
    List<PoissonVO> getPoissons();

    /**
     * @param id
     * @return poissonvo object
     */
    PoissonVO getPoisson(int id);

    /**
     * @param poisson
     */
    void ajout(PoissonVO poisson);

    /**
     * @param poissonVO
     */
    void delete(PoissonVO poissonVO);

    /**
     * @param poissonDO
     * @return poissonvo object
     */
    PoissonVO map(PoissonDO poissonDO);

    /**
     * @param poissonVO
     * @return poissondo object
     */
    PoissonDO map(PoissonVO poissonVO);
}
