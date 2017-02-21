package com.javaquarium.business;

import com.javaquarium.beans.web.PoissonVO;

import java.util.List;

/**
 * Created by quentin on 16/02/2017.
 */
public interface IPoissonService {

    List<PoissonVO> getPoissons();

    PoissonVO getPoisson(int id);

    void ajout(PoissonVO poisson);


}
