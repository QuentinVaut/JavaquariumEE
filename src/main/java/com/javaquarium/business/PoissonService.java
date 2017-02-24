package com.javaquarium.business;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.repository.PoissonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoissonService implements IPoissonService {
    @Autowired
    private PoissonRepository poissonRepository;

    /**
     * @return list of poissonvo
     */
    public List<PoissonVO> getPoissons() {
        ArrayList<PoissonVO> lstPoisson = new ArrayList<>();
        for (PoissonDO poisson : poissonRepository.findAll()) {
            lstPoisson.add(map(poisson));
        }
        return lstPoisson;
    }

    /**
     * @param id
     * @return poissonvo object
     */
    public PoissonVO getPoisson(int id) {
        return map(poissonRepository.findOne(id));
    }

    /**
     * @param poisson
     */
    @Override
    public void ajout(PoissonVO poisson) {
        poissonRepository.save(map(poisson));
    }

    /**
     * @param poissonVO
     */
    @Override
    public void delete(PoissonVO poissonVO) {
        poissonRepository.delete(map(poissonVO));
    }

    /**
     * @param poissonDO
     * @return poissonvo object
     */
    @Override
    public PoissonVO map(PoissonDO poissonDO) {
        PoissonVO poissonVO = new PoissonVO();
        poissonVO.setCode(String.valueOf(poissonDO.getId()));
        poissonVO.setEspece(String.valueOf(poissonDO.getNom()));
        poissonVO.setCouleur(String.valueOf(poissonDO.getCouleur()));
        poissonVO.setDescription(String.valueOf(poissonDO.getDescritpion()));
        poissonVO.setDimension(String.valueOf("L : " + poissonDO.getLargeur() + " x l :" + poissonDO.getLongeur()));
        poissonVO.setEspece(String.valueOf(poissonDO.getNom()));
        poissonVO.setPrix(String.valueOf(poissonDO.getPrix()));
        return poissonVO;
    }

    /**
     * @param poissonVO
     * @return poissondo object
     */
    @Override
    public PoissonDO map(PoissonVO poissonVO) {
        PoissonDO poissonDo = new PoissonDO();
        if (poissonVO.getCode() != null) {
            poissonDo.setId(Integer.parseInt(poissonVO.getCode()));
        }
        poissonDo.setCouleur(poissonVO.getCouleur());
        poissonDo.setDescritpion(poissonVO.getDescription());
        poissonDo.setLargeur(Float.parseFloat(poissonVO.getDimension().split("x")[0].replaceAll("[^\\d.]+|\\.(?!\\d)", "")));
        poissonDo.setLongeur(Float.parseFloat(poissonVO.getDimension().split("x")[1].replaceAll("[^\\d.]+|\\.(?!\\d)", "")));
        poissonDo.setNom(poissonVO.getEspece());
        poissonDo.setPrix(Integer.parseInt(poissonVO.getPrix()));
        return poissonDo;
    }
}