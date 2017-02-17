package com.javaquarium.action;

import com.javaquarium.beans.web.LoginVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by quentin on 16/02/2017.
 */
@Controller
public class LoginAction {
    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginVO", new LoginVO());
        return "UC00_login";
    }


    @PostMapping("/login")
    public String checkLoginInfo(@Valid LoginVO loginVO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }
        return "redirect:/listerEspeces";
    }
}
