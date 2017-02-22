package com.javaquarium.action;

import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.MyUserDetailsService;
import com.javaquarium.business.PoissonService;
import com.javaquarium.repository.PoissonRepository;
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
 * Created by quentin on 17/02/2017.
 */
@Controller
public class AddPoisson {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PoissonRepository poissonRepository;
    @Autowired
    private MyUserDetailsService userDetailsService;
    private IPoissonService poissonService;
    private List<UserPoissonDO> userPoissonDOS;
    private UserDetails userDetails;

    @RequestMapping(value = "/addEspeceToAquarium/{idFish}", method = RequestMethod.GET)
    public String addEspeceToAquarium(@PathVariable String idFish, Model model, HttpSession session) {
        userPoissonDOS = (ArrayList) session.getAttribute("userPoissonDOS");
        userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        poissonService = new PoissonService(poissonRepository);
        UserPoissonDO userPoissonDO = new UserPoissonDO();
        userPoissonDO.setUser(userDetailsService.loadMyUserByUsername(userDetails.getUsername()));
        userPoissonDO.setPoissonDO(poissonService.map(poissonService.getPoisson(Integer.parseInt(idFish))));
        userPoissonDOS.add(userPoissonDO);
        logger.warn("SIZE ADD : " + userPoissonDOS.size());
        return "redirect:/listerEspeces";
    }
}