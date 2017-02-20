package com.javaquarium.action;

import com.javaquarium.beans.web.AquariumVO;
import com.javaquarium.beans.web.LoginVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by quentin on 16/02/2017.
 */
@Controller
@SessionAttributes( value="myAquarium", types={AquariumVO.class} )
public class LoginAction {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginVO", new LoginVO());


        return "UC00_login";
    }


    @PostMapping("/login")
    public String checkLoginInfo(@Valid LoginVO loginVO,HttpSession session, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            logger.warn("Login form Has error");
            return "form";
        }
        logger.warn("Login form Has NO error");
        //session.setAttribute("myAquarium",new AquariumVO());
        return "redirect:/listerEspeces";
    }
}
