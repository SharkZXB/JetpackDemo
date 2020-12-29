package com.shark.jetpackdemo.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.shark.jetpackdemo.R;
import com.shark.jetpackdemo.viewbinding.ViewBindingFragment;


/**
 * 布局和绑定表达式
 */
public class DataBindingActivity extends AppCompatActivity {

    private ActivityDataBindingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 其中一种绑定方式
        binding = ActivityDataBindingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 其中一种方式
        // binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);

        User user = new User("Test", "User");
        binding.setUser(user);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            User user1 = new User("Test2", "User2");
            binding.setUser(user1);
        }, 2000);

        // Fragment 填充
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.rl_contain, new DataBindingFragment(), DataBindingFragment.class.getName());
        ft.commit();

        // 列表填充
        DataBindingRVAdapter adapter = new DataBindingRVAdapter();
        binding.rv.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        binding.rv.setLayoutManager(manager);

        new Handler(Looper.getMainLooper()).postDelayed(()->{
            adapter.upData();
        },3000);

    }
}