package com.abings.strategymodel.Strategy;

/**
 * Created by HaomingXu on 2016/8/25.
 */
public class CashReturn extends CashSuper {

    private int money = 0;
    private int returnCash = 0;

    public CashReturn(int money,int returnCash){
        this.money = money;
        this.returnCash = returnCash;
    }

    @Override
    public double CashMoney(double money) {
        double temp = money >= this.money ?money - returnCash:money;
        return temp;
    }

    @Override
    public String getType() {
        return "满"+money+"返现"+returnCash;
    }
}
