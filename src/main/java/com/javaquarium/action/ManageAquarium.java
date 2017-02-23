package com.javaquarium.action;

import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.IPoissonService;
import com.javaquarium.business.PoissonService;
import com.javaquarium.repository.PoissonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by quentin on 23/02/2017.
 */
@Controller
public class ManageAquarium {
    @Autowired
    private PoissonRepository poissonRepository;
    private IPoissonService poissonService;


    @RequestMapping("/ManageAquarium/AddEspece")
    public String ajoutEspece(Model model) {
        model.addAttribute("poissonVO", new PoissonVO());
        return "UC02_ajoutEspece";
    }

    @PostMapping("/ManageAquarium/AddEspece")
    public String ajoutEspece(@ModelAttribute PoissonVO poissonVO) {
        poissonService = new PoissonService(poissonRepository);
        poissonService.ajout(poissonVO);
        System.out.println("Poisson : " + poissonVO.getEspece());
        return "redirect:/listerEspeces";
    }
}
