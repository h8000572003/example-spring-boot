package com.koyeb.examplespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//@EnableWebMvc
@SpringBootApplication
@Controller
public class ExampleSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringBootApplication.class, args);
    }

    //    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("forward:/index.html");
//    }
    @GetMapping("/")
    public String index() {
        return "forward:/index.html";
    }

}
