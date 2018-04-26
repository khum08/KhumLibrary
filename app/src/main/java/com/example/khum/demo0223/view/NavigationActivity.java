package com.example.khum.demo0223.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.khum.demo0223.R;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/4/25
 *     desc   :
 * </pre>
 */
public class NavigationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_navigation);
        findViewById(R.id.toolbar).setOnClickListener(v -> startActivity(new Intent(NavigationActivity.this,
                ToolbarActivity.class)));

    }
}
