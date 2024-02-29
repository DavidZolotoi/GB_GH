package gb.study.hw16_07_01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @GetMapping("/private-data")
    public String privateData() {
        return "private-data.html";
    }

    @GetMapping("/public-data")
    public String publicData() {
        return "public-data.html";
    }
}
