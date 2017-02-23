package hibernate.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by скурихин on 26.11.2016.
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public ModelAndView method() {
        ModelAndView hello = new ModelAndView("hello");
        hello.addObject("string", "name");
        return hello;
    }
}
