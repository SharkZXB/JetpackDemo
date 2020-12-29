package com.shark.jetpackdemo.viewbinding;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.shark.jetpackdemo.databinding.FragmentViewBindingBinding;

/**
 * author : 三丰
 * date   : 2020/12/29
 * desc   :
 * <p>
 * 在 Fragment 中使用视图绑定
 * <p>
 * 如需设置绑定类的实例以供 Fragment 使用，请在 Fragment 的 onCreateView() 方法中执行以下步骤：
 * <p>
 * 调用生成的绑定类中包含的静态 inflate() 方法。此操作会创建该绑定类的实例以供 Fragment 使用。
 * 通过调用 getRoot() 方法或使用 Kotlin 属性语法获取对根视图的引用。
 * 从 onCreateView() 方法返回根视图，使其成为屏幕上的活动视图。
 * <p>
 * 注意：inflate() 方法会要求您传入布局膨胀器。如果布局已膨胀，您可以调用绑定类的静态 bind() 方法。如需了解详情，请查看视图绑定 GitHub 示例中的例子。
 */
public class ViewBindingFragment extends Fragment {

    private FragmentViewBindingBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentViewBindingBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnWhereIAm.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "我在哪里 --> Fragment", Toast.LENGTH_SHORT).show();
        });

        binding.btnWhoAmI.setOnClickListener(v -> {
            Toast.makeText(getActivity(), "我是谁 --> Fragment ", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // TODO 注意：Fragment 的存在时间比其视图长。请务必在 Fragment 的 onDestroyView() 方法中清除对绑定类实例的所有引用。
        binding = null;
    }

}
