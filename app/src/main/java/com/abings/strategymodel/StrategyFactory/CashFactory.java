package com.abings.strategymodel.StrategyFactory;

import com.abings.strategymodel.Strategy.CashContext;
import com.abings.strategymodel.Strategy.CashDebate;
import com.abings.strategymodel.Strategy.CashNormal;
import com.abings.strategymodel.Strategy.CashReturn;

/**
 * Created by Shuwen on 2016/8/26.
 */
public class CashFactory {
    public static CashContext createCashSuper(int position){
        CashContext cashContext = null;
        switch (position) {
            case 0:
                cashContext = new CashContext(new CashNormal());
                break;
            case 1:
                cashContext = new CashContext(new CashDebate(0.8));
                break;
            case 2:
                cashContext = new CashContext(new CashDebate(0.5));
                break;
            case 3:
                cashContext = new CashContext(new CashReturn(300, 50));
                break;
        }
        return cashContext;
    }
}
