package com.bula.security.Controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/getUserName")
    @ResponseBody
    public String getUserName() {
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "u";
    }
}
