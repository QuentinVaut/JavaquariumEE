package com.javaquarium.action;


import com.javaquarium.beans.data.IPoissonService;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.PoissonService;
import com.javaquarium.repository.PoissonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by quentin on 16/02/2017.
 */
@Controller
public class AjoutEspeceAction {
    @Autowired
    private PoissonRepository poissonRepository;
    private IPoissonService poissonService;

    @RequestMapping("/ajoutEspece")
    public String ajoutEspece(Model model) {
        model.addAttribute("poissonVO", new PoissonVO());
        return "UC02_ajoutEspece";
    }

    @PostMapping("/ajoutEspece")
    public String ajoutEspece(@ModelAttribute PoissonVO poissonVO) {
        poissonService = new PoissonService(poissonRepository);
        poissonService.ajout(poissonVO);
        System.out.println("Poisson : " + poissonVO.getEspece());
        return "redirect:/listerEspeces";
    }
}
