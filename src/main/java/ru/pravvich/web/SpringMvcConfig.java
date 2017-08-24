package ru.pravvich.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Author : Pavel Ravvich.
 * Created : 18.08.17.
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/get_all_items").setViewName("all_items");

        registry.addViewController("/login").setViewName("login");

        registry.addViewController("/get_all_items/get_single_item_by_id")
                .setViewName("single_item");

        registry.addViewController("/get_all_items/add_item_page")
                .setViewName("add_item");
    }
}
