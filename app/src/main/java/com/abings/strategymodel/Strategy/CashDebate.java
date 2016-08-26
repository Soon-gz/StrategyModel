package com.abings.strategymodel.Strategy;

/**
 * Created by Shuwen on 2016/8/25.
 */
public class CashDebate extends CashSuper {

    private double debate = 1;
    public CashDebate(double debate){
        this.debate = debate;
    }
    @Override
    public double CashMoney(double money) {
        return money*debate;
    }

    @Override
    public String getType() {
        return "打"+debate+"折";
    }
}
