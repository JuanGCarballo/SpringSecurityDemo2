package es.neesis.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/private/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/private/helloAdmin").setViewName("helloAdmin");
        registry.addViewController("private/list").setViewName("list");
    }

}
