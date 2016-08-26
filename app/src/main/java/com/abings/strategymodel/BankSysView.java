package com.abings.strategymodel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.abings.strategymodel.Strategy.CashContext;
import com.abings.strategymodel.StrategyFactory.CashFactory;

/**
 * Created by Shuwen on 2016/8/25.
 */
public class BankSysView extends LinearLayout {

    private EditText singlemoney;
    private EditText number;
    private Button sure;
    private Button reset;
    private TextView history;
    private TextView total;
    private StringBuilder stringBuilder;
    private Context context;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;
    private CashContext cashContext;
    private double totalMoney;
    private double allMoney;
    private String[]types = {"全额付款","打8折","打5折","满300返50"};

    public BankSysView(Context context) {
        this(context,null);
    }

    public BankSysView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BankSysView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context =context;
        LayoutInflater.from(context).inflate(R.layout.cashmoneysys, this);
        initView();
        setEvents();
    }

    private void setEvents() {
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cashContext = CashFactory.createCashSuper(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sure.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                double singleMoney = Double.parseDouble(singlemoney.getText().toString().trim());
                double numBer = Double.parseDouble(number.getText().toString().trim());
                totalMoney = cashContext.getResult(singleMoney * numBer);
                allMoney += totalMoney;
                stringBuilder.append("单价:"+singleMoney+"元,"+"数量:"+(int)numBer+","+cashContext.getType()+",合计:"+totalMoney+"元\n");
                total.setText("总计：" + allMoney + "元");
                history.setText(stringBuilder);
            }
        });
        reset.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                singlemoney.setText("");
                number.setText("");
                allMoney = 0;
                stringBuilder.delete(0, stringBuilder.length());
                history.setText("");
                total.setText("总计：");
            }
        });
    }

    private void initView() {
        singlemoney = (EditText) findViewById(R.id.singlemoney);
        number = (EditText) findViewById(R.id.num);
        sure = (Button) findViewById(R.id.sure);
        reset = (Button) findViewById(R.id.reset);
        history = (TextView) findViewById(R.id.history);
        total = (TextView) findViewById(R.id.total);
        spinner = (Spinner) findViewById(R.id.spinner);
        adapter = new ArrayAdapter<>(context,R.layout.text,types);
        stringBuilder = new StringBuilder();
    }

}
