package com.abings.strategymodel.Strategy;

/**
 * Created by Shuwen on 2016/8/25.
 */
public class CashContext {

    private CashSuper cashSuper;

    public CashContext(CashSuper cashSuper){
        this.cashSuper = cashSuper;
    }

    public double getResult(double money){
        return cashSuper.CashMoney(money);
    }

    public String getType(){
        return cashSuper.getType();
    }

}
