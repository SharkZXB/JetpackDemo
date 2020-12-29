package com.shark.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shark.jetpackdemo.databinding.DataBindingActivity;
import com.shark.jetpackdemo.viewbinding.ViewBindingActivity;

/**
 * jetpack 学习
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * ViewBinding
     *
     * @param view
     */
    public void onClickViewBinding(View view) {
        startActivity(new Intent(this, ViewBindingActivity.class));
    }

    /**
     * DataBinding
     *
     * @param view
     */
    public void onClickDataBinding(View view) {
        startActivity(new Intent(this, DataBindingActivity.class));
    }
}