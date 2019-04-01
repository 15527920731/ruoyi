package com.jewelry.system.utils;

import com.jewelry.common.exception.BusinessException;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
public class CookiesUtils {
    @Autowired
    private JwtUtils jwtUtils;

    public Claims getToken(HttpServletRequest request){
        String token=null;
        Cookie[] cookies =  request.getCookies();
            if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals(jwtUtils.getHeader())){
                    token = cookie.getValue();
                }
            }
        }

        if(StringUtils.isEmpty(token)){
            throw new BusinessException(jwtUtils.getHeader() + "不能为空");
        }

        Claims claims = jwtUtils.getClaimByToken(token);
        if(claims == null || jwtUtils.isTokenExpired(claims.getExpiration())){
            throw new BusinessException(jwtUtils.getHeader() + "失效，请重新登录");
        }

        return claims;
    }




}
