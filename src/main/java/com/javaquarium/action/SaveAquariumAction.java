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
 * Created by quentin on 22/02/2017.
 */
@Controller
public class SaveAquariumAction {

    @Autowired
    private PoissonUserRepository poissonUserRepository;
    @Autowired private UserRepository userRepository;
    private IPoissonService poissonService;
    private IPoissonUserService poissonUserService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private List<UserPoissonDO> userPoissonDOS;
    private UserDetails userDetails;

    @RequestMapping("/SaveAquarium")
    public String listerEspeces(Model model, HttpSession session) {
        userPoissonDOS = (ArrayList)session.getAttribute("userPoissonDOS");
        poissonUserService = new PoissonUserService(poissonUserRepository,userRepository);
        logger.warn("SAVE : " + userPoissonDOS.get(0).getPoissonDO().getId() + " USER ID " + userPoissonDOS.get(0).getUser().getId());
        poissonUserService.save(userPoissonDOS);
        return "redirect:/listerEspeces";
    }
}
