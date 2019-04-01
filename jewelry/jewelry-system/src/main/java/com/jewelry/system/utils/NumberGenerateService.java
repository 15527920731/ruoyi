package com.jewelry.system.utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class NumberGenerateService {
   /* @Autowired
    private OrderService orderService;*/

    public  String generateOrderNumber(){
        String exist="";
        String orderNumber="";
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        //14位时间
        do {
            Long time = Long.valueOf((sdf.format(new Date()))).longValue();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < 3; i++) {
                sbf.append(new Random().nextInt(10));
            }
            orderNumber = "M" + time + sbf.toString();
            //exist = orderService.existOrderNumber(orderNumber);
        }while (!StringUtils.isEmpty(exist));
        return orderNumber;
    }



}
