package com.offcn.pay;

import java.util.HashMap;
import java.util.Map;

public class payLog {

    public void payWeixin(String out_trade_no){
        System.out.println("微信支付");
    }

    public Map queryStatus(String out_trade_no){
        return new HashMap();
    }
}
