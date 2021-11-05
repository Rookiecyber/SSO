package cn.edu.cqu.authserver.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/app1")
@Controller
public class App1Controller {
    @RequestMapping("/index")
    public String app1(){
        return "app1";
    }
}
