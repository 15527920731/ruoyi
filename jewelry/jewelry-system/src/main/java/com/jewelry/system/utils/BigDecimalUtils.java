package com.jewelry.system.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalUtils {
    private  static DecimalFormat format = new DecimalFormat("0.00");
    private  static DecimalFormat format2 = new DecimalFormat("0");



    //加法
    public static BigDecimal add(BigDecimal d1,BigDecimal d2){
        return d1.add(d2);
    }
    //减法
    public static BigDecimal subtract(BigDecimal d1,BigDecimal d2){
        return d1.subtract(d2);
    }
    //乘法
    public static BigDecimal multiply(BigDecimal d1,BigDecimal d2){
        return new BigDecimal(format.format(d1.multiply(d2)));
    }
    //乘法---四舍五入取整
    public static String multiplyZheng(BigDecimal d1,BigDecimal d2){
        return format2.format(d1.multiply(d2));
    }


    public static void main(String[] args) {
        String aa=BigDecimalUtils.multiplyZheng(new BigDecimal(1.1),new BigDecimal(4));
        System.out.println(aa);
    }



    //除法
    public static BigDecimal divide(BigDecimal d1,BigDecimal d2){
        return new BigDecimal(format.format(d1.divide(d2)));
    }



}
