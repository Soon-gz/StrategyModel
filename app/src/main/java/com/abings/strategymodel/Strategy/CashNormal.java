package com.abings.strategymodel.Strategy;

/**
 * Created by Shuwen on 2016/8/25.
 */
public class CashNormal extends CashSuper {
    @Override
    public double CashMoney(double money) {
        return money;
    }

    @Override
    public String getType() {
        return "全额付款";
    }
}
