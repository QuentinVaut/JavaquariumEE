package com.javaquarium.action;

import com.javaquarium.beans.data.UserPoissonDO;
import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.IPoissonUserService;
import com.javaquarium.business.PoissonService;
import com.javaquarium.business.PoissonUserService;
import com.javaquarium.repository.PoissonRepository;
import com.javaquarium.repository.PoissonUserRepository;
import com.javaquarium.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 16/02/2017.
 */
@Controller
public class ListerEspecesAction {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PoissonRepository poissonRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PoissonUserRepository poissonUserRepository;
    private IPoissonService poissonService;
    private IPoissonUserService poissonUserService;
    private List<UserPoissonDO> userPoissonDOS;
    private UserDetails userDetails;

    @RequestMapping("/listerEspeces")
    public String listerEspeces(Model model, HttpSession session) {
        userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        poissonService = new PoissonService(poissonRepository);
        poissonUserService = new PoissonUserService(poissonUserRepository, userRepository);
        userPoissonDOS = (ArrayList) session.getAttribute("userPoissonDOS");
        //userPoissonDOS = poissonUserService.getUserPoissons(userDetails.getUsername());
        if (userPoissonDOS.size() == 0) {
            userPoissonDOS.addAll(poissonUserService.getUserPoissons(userDetails.getUsername()));
        }
        logger.warn("Poisson Session : " + userPoissonDOS.size());

        model.addAttribute("lstPoissonDO", poissonService.getPoissons());
        if (userPoissonDOS != null) {
            model.addAttribute("sizeAquarium", userPoissonDOS.size());
        } else {
            model.addAttribute("sizeAquarium", 0);
        }
        return "UC01_especes";
    }
}