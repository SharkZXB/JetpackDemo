package com.shark.jetpackdemo.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.shark.jetpackdemo.R;

/**
 * 生命周期
 */
public class LifecycleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        getLifecycle().addObserver(new MyObserver());
    }

}