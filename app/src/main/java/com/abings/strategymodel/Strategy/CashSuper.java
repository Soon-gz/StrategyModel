package com.abings.strategymodel.Strategy;

/**
 *抽象策略，一个算法
 *@author Shuwen
 *created at 2016/8/25 15:54
 */
public abstract class CashSuper {
    public abstract double CashMoney(double money);
    public abstract String getType();
}
