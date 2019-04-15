package com.zsgc;

import org.junit.Test;

public class Test1 {
    @Test
  public void t01(){
        String keywords="192.168.1.2";

        String regex="([1-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])){3}";

        System.out.println(keywords.matches(regex));


    }
}
