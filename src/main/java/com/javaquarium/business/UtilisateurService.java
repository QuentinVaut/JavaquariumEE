package com.javaquarium.business;

import com.javaquarium.beans.data.UtilisateurDO;
import com.javaquarium.beans.web.UtilisateurVO;
import com.javaquarium.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 20/02/2017.
 */
@Service
public class UtilisateurService {

   /* private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }


    @Override
    public List<UtilisateurVO> getUsers() {
        ArrayList<UtilisateurVO> lstUtil = new ArrayList<>();
        for(UtilisateurDO utilisateurDO : utilisateurRepository.findAll()) {
            lstUtil.add(map(utilisateurDO));
        }
        return lstUtil;
    }

    @Override
    public UtilisateurVO getUser(String login) {

        return map(utilisateurRepository.findOneByUsername(login));
    }

    @Override
    public void ajout(UtilisateurVO utilisateurVO) {
        utilisateurRepository.save(map(utilisateurVO));
    }

    @Override
    public boolean checkLogin(String login, String password) {
        return false;
    }

    @Override
    public UtilisateurDO map(UtilisateurVO utilisateurVO) {
        UtilisateurDO utilisateurDO = new UtilisateurDO();
        utilisateurDO.setId(utilisateurVO.getId());
        utilisateurDO.setLogin(utilisateurVO.getUsername());
        utilisateurDO.setPassword(utilisateurVO.getPassword());
        return utilisateurDO;
    }

    @Override
    public UtilisateurVO map(UtilisateurDO utilisateurDO) {
        UtilisateurVO utilisateurVO = new UtilisateurVO();
        utilisateurVO.setId(utilisateurDO.getId());
        utilisateurVO.setUsername(utilisateurDO.getLogin());
        utilisateurVO.setPassword(utilisateurDO.getPassword());
        return utilisateurVO;
    }*/
}
