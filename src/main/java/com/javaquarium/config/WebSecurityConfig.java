package com.javaquarium.config;

import com.javaquarium.business.MyUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * Created by quentin on 16/02/2017.
 */
@Configuration
@EnableWebSecurity
@ComponentScan("com.javaquarium")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MyUserDetailsService userDetailsService;


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/registration").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/listerEspeces")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(WebSecurity security){
        security.ignoring().antMatchers("/resources/**");
    }
}