package com.example.asus.graduationproject.DailyMod;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.asus.graduationproject.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Random;

public class StepCountActivity extends AppCompatActivity  {
    //计步模块

    TextView today_step;
    TextView calorie;
    BarChart mBarChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_count);

        today_step=findViewById(R.id.today_step);
        today_step.setText("今天已运动"+StepCountService.step+"步");
        calorie=findViewById(R.id.calorie);
        calorie.setText("预计消耗"+(int)0.0232*StepCountService.step+"千卡");
        mBarChart=findViewById(R.id.mBarChart);
        mBarChart.setDrawBarShadow(false);
        mBarChart.setDrawValueAboveBar(true);
        mBarChart.getDescription().setEnabled(false);
        // 扩展现在只能分别在x轴和y轴
        mBarChart.setPinchZoom(false);
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        // 只有1天的时间间隔
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(7);
        xAxis.setAxisMaximum(7f);
        xAxis.setAxisMinimum(1f);
        xAxis.setAvoidFirstLastClipping(false);

        YAxis leftAxis = mBarChart.getAxisLeft();
        leftAxis.setLabelCount(5, false);
        leftAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        leftAxis.setSpaceTop(10f);
        //这个替换setStartAtZero(true)
        leftAxis.setAxisMinimum(0f);
        leftAxis.setAxisMaximum(100000f);
        YAxis rightAxis = mBarChart.getAxisRight();
        rightAxis.setEnabled(false);
        ArrayList<BarEntry> list=new ArrayList<>();
        for(int i=0;i<7;i++){
            list.add(new BarEntry(i+1,new Random().nextInt(100000)));
        }
        setData(list);
    }
    private void setData(ArrayList yVals1) {
        float start = 1f;
        BarDataSet set1;
        if (mBarChart.getData() != null &&
                mBarChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) mBarChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mBarChart.getData().notifyDataChanged();
            mBarChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "2017年工资涨幅");
            Legend legend = mBarChart.getLegend();
            legend.setEnabled(false);
            //设置有四种颜色
            set1.setColors(
                    Color.parseColor("#00FF99"),Color.parseColor("#00FFCC"),Color.parseColor("#00CCFF"),
                    Color.parseColor("#0066FF"),Color.parseColor("#CCFF00"),Color.parseColor("#CC00FF"),
                    Color.parseColor("#FF0066"));
            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(0.5f);
            //设置数据
            mBarChart.setData(data);
        }
    }



    @Override
    protected void onResume() {
        super.onResume();

    }
}
