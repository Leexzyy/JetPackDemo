package com.example.viewmodel_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    MyVIewModle myVIewModle;
    Button btn1,btn2;
    TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //使用ViewModelProviders来邦定ViewModle,
        myVIewModle = ViewModelProviders.of(this).get(MyVIewModle.class);
        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        //onCreate生命周期中就得要得到Text的值 否则旋转的时候activity生命周期会被重新创建 从而没有值
        tv1.setText(String.valueOf(myVIewModle.number));

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVIewModle.number++;
                //setText是string类型的 需要使用类型转换 ，从这里可以知道怎么得到myViewModle中的number的值
                tv1.setText(String.valueOf(myVIewModle.number));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVIewModle.number += 2;
                tv1.setText(String.valueOf(myVIewModle.number));
            }
        });

    }
}
