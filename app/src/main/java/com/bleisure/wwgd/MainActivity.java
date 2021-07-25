package com.bleisure.wwgd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ColorStateList def;
    TextView item1, item2, item3, selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.navbar);
        setSupportActionBar(toolbar);

        item1 = findViewById(R.id.item1);
        item2 = findViewById(R.id.item2);
        item3 = findViewById(R.id.item3);

        item1.setOnClickListener(this::onClick);
        item2.setOnClickListener(this::onClick);
        item3.setOnClickListener(this::onClick);

        selected = findViewById(R.id.select);
        def = item2.getTextColors();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.item1) {
            selected.animate().y(0).setDuration(100);
            item1.setTextColor(Color.WHITE);
            item1.animate().scaleX(1.2f).setDuration(100);
            item2.setTextColor(def);
            item3.setTextColor(def);
        } else if (view.getId() == R.id.item2) {
            item1.setTextColor(def);
            item2.setTextColor(Color.WHITE);
            item2.animate().scaleX(1.2f).setDuration(100);
            item3.setTextColor(def);
            int size = item1.getHeight();
            selected.animate().y(size).setDuration(100);
        } else if (view.getId() == R.id.item3) {
            item1.setTextColor(def);
            item2.setTextColor(def);
            item3.setTextColor(Color.WHITE);
            item3.animate().scaleX(1.2f).setDuration(100);
            int size = item1.getHeight() * 2;
            selected.animate().y(size).setDuration(100);
        }
    }
}