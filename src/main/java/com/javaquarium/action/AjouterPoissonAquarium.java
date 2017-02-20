package com.javaquarium.action;

import com.javaquarium.beans.data.IPoissonService;
import com.javaquarium.beans.web.AquariumVO;
import com.javaquarium.business.PoissonService;
import com.javaquarium.repository.PoissonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by quentin on 17/02/2017.
 */
@Controller
public class AjouterPoissonAquarium {

    @Autowired
    private PoissonRepository poissonRepository;
    private IPoissonService poissonService;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/addEspeceToAquarium/{idFish}", method = RequestMethod.GET)
    public String addEspeceToAquarium(@PathVariable String idFish, Model model, HttpSession session) {

        poissonService = new PoissonService(poissonRepository);
        logger.warn("Session : " + session.getAttribute("myAquarium").getClass().getSimpleName());
        AquariumVO aquariumVO = (AquariumVO) session.getAttribute("myAquarium");
        aquariumVO.getLstPoissonsAquarium().add(poissonService.getPoisson(Integer.parseInt(idFish)));
        logger.warn("Session : " + aquariumVO.getLstPoissonsAquarium().size());
        return "redirect:/listerEspeces";
    }
}