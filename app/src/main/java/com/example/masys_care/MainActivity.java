package com.example.masys_care;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    HorizontalBarChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mChart = findViewById(R.id.chart1);

        setData(6, 50);
        customizeChartAppearance();

        // Find the "See all" CardView by its ID
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.Seeall);
        // Set an OnClickListener for the CardView
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the click event here
                Intent intent = new Intent(MainActivity.this, See_All.class);
                startActivity(intent);
            }
        });
    }

    private void setData(int count, int range) {
        ArrayList<BarEntry> yVals = new ArrayList<>();
        float barWidth = 9f;
        float spaceForBar = 4f;

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            yVals.add(new BarEntry(i * spaceForBar, val));
        }

        BarDataSet set1 = new BarDataSet(yVals, "User Data");

        // Set custom background color for bars (rounded corners effect)
        set1.setColors(ColorTemplate.MATERIAL_COLORS);
        set1.setGradientColor(Color.rgb(0, 100, 0), Color.rgb(0, 200, 0));

        BarData data = new BarData(set1);
        mChart.setData(data);
    }

    private void customizeChartAppearance() {
        // Customize X-axis
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextSize(12f);
        xAxis.setTextColor(Color.BLACK);

        // Customize Y-axis
        mChart.getAxisLeft().setValueFormatter(new LargeValueFormatter("$"));

        // Customize legend
        Legend legend = mChart.getLegend();
        legend.setForm(Legend.LegendForm.SQUARE);
        legend.setTextSize(12f);

        // Apply animation
        mChart.animateY(1000, Easing.EaseInOutQuad);

        // Additional styling
        mChart.setBackgroundColor(Color.WHITE);
        mChart.setDrawBorders(false);
        mChart.setExtraBottomOffset(16f);
    }
}
