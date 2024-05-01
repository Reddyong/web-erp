package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    // 책 리스트 보기
    @GetMapping(path = "/restlist")
    public String restList() {

        return "restlist";
    }

    @GetMapping(path = "/restregister")
    public String restRegister() {

        return "restregister";
    }
}
