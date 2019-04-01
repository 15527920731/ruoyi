package com.jewelry.system.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class MathRandomUtils {

    private static final String SYMBOLS = "0123456789"; // 数字

    private static final Random RANDOM = new SecureRandom();

    public String mathRandom(int wei){
        char[] nonceChars = new char[wei];

        for (int index = 0; index < nonceChars.length; ++index) {
            nonceChars[index] = SYMBOLS.charAt(RANDOM.nextInt(SYMBOLS.length()));
        }
        return new String(nonceChars);
    }


    /*public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(MathRandomUtils.mathRandom(4));
        }

    }*/
}
