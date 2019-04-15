package com.zsgc.tool;

import java.math.BigDecimal;

public class Math0 {
    //小数四舍五入
    public static double round0(Double num,int scale){
        return new BigDecimal(num).divide(new BigDecimal(1),scale,BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
