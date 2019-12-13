package com.karol.travelagency;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/", "classpath:/resources/",
                        "classpath:/static/", "classpath:/public/"

                        , "classpath:/static/assets/");
    }

}