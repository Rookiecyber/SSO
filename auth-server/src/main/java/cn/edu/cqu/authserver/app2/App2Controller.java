package cn.edu.cqu.authserver.app2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/app2")
@Controller
public class App2Controller {
    @RequestMapping("/index")
    public String app2(){
        return "app2";
    }
}
