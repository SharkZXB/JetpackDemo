package com.shark.jetpackdemo.viewbinding;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.shark.jetpackdemo.databinding.CustomViewLayoutBinding;

/**
 * author : 三丰
 * date   : 2020/12/29
 * desc   :
 */
public class ViewBindingCustomView extends LinearLayout {

    private CustomViewLayoutBinding binding;

    public ViewBindingCustomView(Context context) {
        super(context);
        init(context);
    }

    public ViewBindingCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ViewBindingCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        // ViewBinding 获取到 binding
        binding = CustomViewLayoutBinding.inflate(LayoutInflater.from(context), this, false);
        binding.btnLeft.setOnClickListener(v -> {
            Toast.makeText(context, "我是右边的", Toast.LENGTH_SHORT).show();
        });

        binding.btnRight.setOnClickListener(v -> {
            Toast.makeText(context, "我是左边的", Toast.LENGTH_SHORT).show();
        });

        addView(binding.getRoot());
    }

}
