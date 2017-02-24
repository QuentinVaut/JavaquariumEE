package com.javaquarium.config;

import com.javaquarium.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by quentin on 16/02/2017.
 */
public class ServletInitializer extends SpringBootServletInitializer {
    /**
     * @param application
     * @return springapplicationbuilder object
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}