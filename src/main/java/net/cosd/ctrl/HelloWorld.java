package net.cosd.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {
    @RequestMapping("/")
    public String helloWorld() {
        System.out.println("hello world");
        return "123";
    }
}
