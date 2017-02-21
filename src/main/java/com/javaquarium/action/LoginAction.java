package com.javaquarium.action;


import com.javaquarium.beans.data.User;
import com.javaquarium.business.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by quentin on 16/02/2017.
 */
@Controller
@ComponentScan
public class LoginAction {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
        @Autowired
        private MyUserDetailsService userService;

        @RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
        public ModelAndView login(){
            ModelAndView modelAndView = new ModelAndView();
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = "";
            if (principal instanceof UserDetails) {
                modelAndView.setViewName("redirect:/listerEspeces");
            } else {
                modelAndView.setViewName("login");
            }
            return modelAndView;
        }

        @RequestMapping(value="/registration", method = RequestMethod.GET)
        public ModelAndView registration(){
            ModelAndView modelAndView = new ModelAndView();
            User user = new User();
            modelAndView.addObject("user", user);
            modelAndView.setViewName("registration");
            return modelAndView;
        }

        @RequestMapping(value = "/registration", method = RequestMethod.POST)
        public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
            ModelAndView modelAndView = new ModelAndView();
            User userExists = userService.loadMyUserByUsername(user.getUsername());
            if (userExists != null) {
                bindingResult
                        .rejectValue("username", "error.user",
                                "There is already a user registered with the username provided");
            }
            if (bindingResult.hasErrors()) {
                modelAndView.setViewName("registration");
            } else {
                userService.saveUser(user);
                modelAndView.addObject("successMessage", "User has been registered successfully");
                modelAndView.addObject("user", new User());
                modelAndView.setViewName("registration");
            }
            return modelAndView;
        }
}
