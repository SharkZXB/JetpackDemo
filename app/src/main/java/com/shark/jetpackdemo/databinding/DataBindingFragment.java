package com.shark.jetpackdemo.databinding;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.shark.jetpackdemo.BR;
import com.shark.jetpackdemo.R;

/**
 * author : 三丰
 * date   : 2020/12/29
 * desc   :
 */
public class DataBindingFragment extends Fragment {

    private ViewDataBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data_binding_layout, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        User user = new User("AAA", "BBB");
        // TODO 注意下这里的 BR 我也不知道为什么 方正就这么用的
        binding.setVariable(BR.user, user);

        // 延时出现 默认是空的
        new Handler(Looper.getMainLooper()).postDelayed(()->{
            User2 user2 = new User2("AAA2", "BBB2");
            binding.setVariable(BR.user2, user2);
        },2000);

    }
}
