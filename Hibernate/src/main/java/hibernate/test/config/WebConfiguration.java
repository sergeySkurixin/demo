package hibernate.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by скурихин on 26.11.2016.
 */
@Configuration
@EnableWebMvc
@ComponentScan("hibernate.test.controller")
public class WebConfiguration {

    @Bean
    public InternalResourceViewResolver viewResolver() {
        return new InternalResourceViewResolver("/WEB-INF/pages/", ".jsp");
    }
}
