package com.jewelry.web.controller.font;

import com.jewelry.common.base.AjaxResult;
import com.jewelry.common.exception.BusinessException;
import com.jewelry.common.utils.ServletUtils;
import com.jewelry.common.utils.StringUtils;
import com.jewelry.framework.util.EncryptUtils;
import com.jewelry.framework.web.base.BaseController;
import com.jewelry.system.service.IMemberService;
import com.jewelry.system.utils.JwtUtils;
import com.jewelry.system.utils.MathRandomUtils;
import com.jewelry.system.utils.RedisUtil;
import com.jewelry.system.utils.SmSMessageUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController extends BaseController
{

    @Autowired
    private SmSMessageUtils smSMessageUtils;
    @Autowired
    private IMemberService memberService;

    @GetMapping("/getSmsCode")
    @ResponseBody
    public AjaxResult getSmsCode(String phone,String type){
        if(StringUtils.isEmpty(phone)){
            return AjaxResult.error("请输入手机号！");
        }
        smSMessageUtils.sendSmsMessage(type,phone);
        return AjaxResult.success();
    }


   /* @GetMapping("/fontLogin")
    @ResponseBody
    public String fontLogin(HttpServletRequest request, HttpServletResponse response)
    {
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        return "fontLogin";
    }*/



    @GetMapping("/fontLogin")
    @ResponseBody
    public AjaxResult ajaxLogin(String phone,
                                @RequestParam(value = "password",required = false) String password,
                                @RequestParam(value = "code",required = false) String code,
                                HttpServletResponse response)
    {
        if(StringUtils.isEmpty(phone)){
            throw new BusinessException("请输入手机号！");
        }
        if(StringUtils.isEmpty(password)&& StringUtils.isEmpty(code)){
            throw new BusinessException("输入有误！");
        }
        if(!StringUtils.isEmpty(password)&& !StringUtils.isEmpty(code)){
            throw new BusinessException("输入有误！");
        }
        Cookie cookie=null;
        //密码登录
        if(StringUtils.isNotEmpty(password)){
            cookie=memberService.passwordLogin(phone, EncryptUtils.encrypt(phone,password));
        }
        //验证码登录
        if(StringUtils.isNotEmpty(code)){
            cookie=memberService.codeLogin(phone,code);
        }
        response.addCookie(cookie);
        return AjaxResult.success();
    }




   /* @GetMapping("/register")
    @ResponseBody
    public AjaxResult register(String phone,String code,HttpServletResponse response){
        if(!StringUtils.isEmpty(phone) || !StringUtils.isEmpty(code)){
            throw new BusinessException("输入有误！");
        }
        Cookie cookie=memberService.codeLogin(phone,code);
        response.addCookie(cookie);
        return AjaxResult.success();
    }*/












}
