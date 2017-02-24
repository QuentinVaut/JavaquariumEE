package com.javaquarium.action;

import com.javaquarium.beans.data.PoissonDO;
import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.IPoissonUserService;
import com.javaquarium.business.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 23/02/2017.
 */
@Controller
public class ManageUserAquarium {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MyUserDetailsService userDetailsService;
    @Autowired
    private IPoissonUserService poissonUserService;
    @Autowired
    private IPoissonService poissonService;
    private List<UserPoissonDO> userPoissonDOS;
    private UserDetails userDetails;

    /**
     * @param idFish
     * @param model
     * @param session
     * @return redirection to listerEspeces
     */
    @RequestMapping(value = "/ManageUserAquarium/Add/{idFish}", method = RequestMethod.GET)
    public String addPoissonToUserAquarium(@PathVariable String idFish, Model model, HttpSession session) {
        userPoissonDOS = (ArrayList) session.getAttribute("userPoissonDOS");
        userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserPoissonDO userPoissonDO = new UserPoissonDO();
        userPoissonDO.setUser(userDetailsService.loadMyUserByUsername(userDetails.getUsername()));
        userPoissonDO.setPoissonDO(poissonService.map(poissonService.getPoisson(Integer.parseInt(idFish))));
        userPoissonDOS.add(userPoissonDO);
        return "redirect:/listerEspeces";
    }

    /**
     * @param idFish
     * @param model
     * @param session
     * @return redirection to listerEspeces
     */
    @RequestMapping(value = "/ManageUserAquarium/Delete/{idFish}", method = RequestMethod.GET)
    public String removePoissonToUserAquarium(@PathVariable String idFish, Model model, HttpSession session) {
        userPoissonDOS = (ArrayList) session.getAttribute("userPoissonDOS");
        userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserPoissonDO userPoissonDO = new UserPoissonDO();
        userPoissonDO.setUser(userDetailsService.loadMyUserByUsername(userDetails.getUsername()));
        userPoissonDO.setPoissonDO(poissonService.map(poissonService.getPoisson(Integer.parseInt(idFish))));
        PoissonDO poissonDO = poissonService.map(poissonService.getPoisson(Integer.parseInt(idFish)));
        UserPoissonDO userPoissonDORemove = new UserPoissonDO();

        for (UserPoissonDO userPoisson : userPoissonDOS) {
            if (userPoisson.getPoissonDO().getNom().hashCode() == poissonDO.getNom().hashCode()) {
                userPoissonDORemove = userPoisson;
            }
        }
        userPoissonDOS.remove(userPoissonDORemove);
        return "redirect:/listerEspeces";
    }

    /**
     * @param model
     * @param session
     * @return redirection to listerEspeces
     */
    @RequestMapping("/ManageUserAquarium/Save")
    public String saveUserAquarium(Model model, HttpSession session) {
        userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        userPoissonDOS = (ArrayList) session.getAttribute("userPoissonDOS");
        for (UserPoissonDO userPoissonDO : poissonUserService.getUserPoissons(userDetails.getUsername())) {
            if (!userPoissonDOS.contains(userPoissonDO)) {
                poissonUserService.deleteUserPoisson(userPoissonDO);
            }
        }
        //poissonUserService.deleteUserPoisson(poissonUserService.getUserPoissons(userDetails.getUsername()));
        poissonUserService.save(userPoissonDOS);
        return "redirect:/listerEspeces";
    }

    /**
     * @param model
     * @param session
     * @return redirection to listerEspeces
     */
    @RequestMapping("/ManageUserAquarium/Delete")
    public String removeUserAquarium(Model model, HttpSession session) {
        userPoissonDOS = (ArrayList) session.getAttribute("userPoissonDOS");
        poissonUserService.deleteUserPoisson(userPoissonDOS);
        userPoissonDOS.clear();
        return "redirect:/listerEspeces";
    }
}
