package com.javaquarium.business;

import com.javaquarium.beans.data.UtilisateurDO;
import com.javaquarium.beans.web.UtilisateurVO;

import java.util.List;

/**
 * Created by quentin on 20/02/2017.
 */
public interface IUtilisateurService {
    List<UtilisateurVO> getUsers();
    UtilisateurVO getUser(String login);
    void ajout(UtilisateurVO utilisateurVO);
    boolean checkLogin(String login,String password);
    UtilisateurDO map(UtilisateurVO utilisateurVO);
    UtilisateurVO map(UtilisateurDO utilisateurDO);
}
