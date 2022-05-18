package com.example.testchart;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.model.PieChartData;
import lecho.lib.hellocharts.model.SliceValue;
import lecho.lib.hellocharts.view.PieChartView;

public class BlankFragment extends Fragment {
    private PieChartView pieChartView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }
    private int a1;
    private int a2;
    private int b1;
    private int b2;
    private int sum;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pieChartView = view.findViewById(R.id.chart);
        a1 = 1;
        a2 = 4;
        sum = a1+a2;
        b1 = (int) ((a1/sum)*100f);
        b2 = (int) ((a2/sum)*100f);

        List< SliceValue > pieData = new ArrayList<>();
        pieData.add(new SliceValue(a1, Color.GREEN).setLabel("Đã trả "+(b1)+" %"));
        pieData.add(new SliceValue(a2, Color.YELLOW).setLabel("Chưa trả "+ b2+" %"));

        PieChartData pieChartData = new PieChartData(pieData);
        pieChartData.setHasLabels(true).setValueLabelTextSize(14);
        pieChartData.setHasCenterCircle(true).setCenterText1("Tổng thu nhập").setCenterText1FontSize(32).setCenterText1Color(Color.parseColor("#0097A7"));
        pieChartView.setPieChartData(pieChartData);}
}