package com.javaquarium.action;

import com.javaquarium.beans.data.IPoissonService;
import com.javaquarium.beans.web.AquariumVO;
import com.javaquarium.beans.web.PoissonVO;
import com.javaquarium.business.PoissonService;
import com.javaquarium.repository.PoissonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by quentin on 16/02/2017.
 */
@Controller
@SessionAttributes( value="myAquarium", types={AquariumVO.class} )
public class ListerEspecesAction {
    @Autowired
    private PoissonRepository poissonRepository;
    private IPoissonService poissonService;

    @RequestMapping("/listerEspeces")
    public String listerEspeces(Model model, HttpSession session) {
        poissonService = new PoissonService(poissonRepository);
        model.addAttribute("lstPoissonDO", poissonService.getPoissons());
        return "UC01_especes";
    }


}