package com.javaquarium.business;

import com.javaquarium.beans.data.IPoissonService;
import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.repository.PoissonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PoissonService implements IPoissonService {

    private final PoissonRepository poissonRepository;

    @Autowired
    public PoissonService(PoissonRepository poissonRepository) {
        this.poissonRepository = poissonRepository;
    }

    public List<PoissonVO> getPoissons() {
        ArrayList<PoissonVO> lstPoisson = new ArrayList<>();
        for (PoissonDO poisson : poissonRepository.findAll()) {
            PoissonVO poissonVO = new PoissonVO();
            poissonVO.setCode(String.valueOf(poisson.getId()));
            poissonVO.setEspece(String.valueOf(poisson.getNom()));
            poissonVO.setCouleur(String.valueOf(poisson.getCouleur()));
            poissonVO.setDescription(String.valueOf(poisson.getDescritpion()));
            poissonVO.setDimension(String.valueOf("L : " + poisson.getLargeur()  + " x l :" + poisson.getLongeur()));
            poissonVO.setEspece(String.valueOf(poisson.getNom()));
            poissonVO.setPrix(String.valueOf(poisson.getPrix()));
            lstPoisson.add(poissonVO);
        }
        return lstPoisson;
    }

    @Override
    public void ajout(PoissonVO poisson) {
        PoissonDO poissonDo = new PoissonDO();
        poissonDo.setCouleur(poisson.getCouleur());
        poissonDo.setDescritpion(poisson.getDescription());
        poissonDo.setLargeur(Float.parseFloat(poisson.getDimension()));
        poissonDo.setLongeur(Float.parseFloat(poisson.getDimension()));
        poissonDo.setNom(poisson.getEspece());
        poisson.setPrix(poisson.getPrix());
        poissonRepository.save(poissonDo);
    }

}