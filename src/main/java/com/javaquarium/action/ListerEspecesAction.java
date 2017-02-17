package com.javaquarium.action;

import com.javaquarium.beans.data.IPoissonService;
import com.javaquarium.business.PoissonService;
import com.javaquarium.repository.PoissonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by quentin on 16/02/2017.
 */
@Controller
public class ListerEspecesAction {
    @Autowired
    private PoissonRepository poissonRepository;
    private IPoissonService poissonService;

    @RequestMapping("/listerEspeces")
    public String listerEspeces(Model model) {
        poissonService = new PoissonService(poissonRepository);
        model.addAttribute("lstPoissonDO", poissonService.getPoissons());

        return "UC01_especes";
    }
}