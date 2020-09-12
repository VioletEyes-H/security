package com.bula.security.Controller;

import com.bula.security.entity.User;
import com.bula.security.util.JwtTokenUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @GetMapping("/getUserName")
    @ResponseBody
    public String getUserName() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();//获取user自定义对象
        if (obj instanceof User) {
            String openId = ((User) obj).getOpenId();
            System.out.println(openId);
        }
//        System.out.println(user.getOpenId());
        return "u";
    }

    @GetMapping("/login")
    @ResponseBody
    public String login(String openId, String username, String password) {
        User user = new User(openId, username, password, null);
        String token = new JwtTokenUtil().generateToken(user);
        return token;
    }
}
