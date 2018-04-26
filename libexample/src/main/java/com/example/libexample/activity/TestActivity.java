package com.example.libexample.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.khum.demo0223.R.layout.activity_test);
        initView();
    }

    private void initView() {
        findViewById(com.example.khum.demo0223.R.id.tv_pull).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TestActivity.this,PullActivity.class));
            }
        });
    }
}
