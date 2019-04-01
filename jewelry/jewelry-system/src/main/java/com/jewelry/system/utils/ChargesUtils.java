package com.jewelry.system.utils;

import com.jewelry.system.domain.Charges;

import java.math.BigDecimal;

public class ChargesUtils {
    public static BigDecimal getCharges(Charges charges,String productType){
        BigDecimal yi=new BigDecimal(1);
        BigDecimal changes=new BigDecimal(0);
        if("无色钻石".equals(productType)){
            changes=charges.getWuSe();
        }else if("彩色钻石".equals(productType)){
            changes=charges.getCaiSe();
        }
        else if("红宝石".equals(productType)){
            changes=charges.getHongBaoShi();
        }
        else if("蓝宝石".equals(productType)){
            changes=charges.getLanBaoShi();
        }
        else if("祖母绿".equals(productType)){
            changes=charges.getZuMu();
        }
        else if("其它稀有宝石".equals(productType)){
            changes=charges.getQiTa();
        }
        else if("首饰款式".equals(productType)){
            changes=charges.getShouShi();
        }
        else if("品牌荟萃".equals(productType)){
            changes=charges.getPinPai();
        }else {
            return changes;
        }
        return BigDecimalUtils.add(yi, BigDecimalUtils.divide(changes,new BigDecimal(100)));
    }
}
