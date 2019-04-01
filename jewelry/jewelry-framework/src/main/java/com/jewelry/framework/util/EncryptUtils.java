package com.jewelry.framework.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;


public class EncryptUtils {
    public static  String encrypt(String Phone,String pwd){
        String hashAlgorithmName = "MD5";
        String credentials = pwd;
        int hashIterations = 223;
        Object salt=Phone;
        Object obj = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
        return obj.toString();
    }

    public static void main(String[] args) {
        System.out.printf(EncryptUtils.encrypt("15527920731","123"));
    }
}
