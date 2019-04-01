package com.jewelry.web.controller.font;

import com.jewelry.system.domain.Member;
import com.jewelry.system.utils.LoginUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/font")
public class TestFontController {


    @GetMapping("/test")
    @ResponseBody
    public Object test(@LoginUser Member member,HttpServletRequest request){
        return member;
    }



    @GetMapping("/websoc")
    public String websoc(){
        return "websoc";
    }



}
