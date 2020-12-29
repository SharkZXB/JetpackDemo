package com.shark.jetpackdemo.databinding;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.shark.jetpackdemo.BR;
import com.shark.jetpackdemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * author : 三丰
 * date   : 2020/12/29
 * desc   :
 */
public class DataBindingRVAdapter extends RecyclerView.Adapter<DataBindingRVAdapter.InnerVH> {

    private final List<User> userList;

    public DataBindingRVAdapter() {
        userList = new ArrayList<>(30);
        for (int i = 0; i < 30; i++) {
            userList.add(new User("A" + i, "B" + i));
        }
    }

    /**
     * 模拟刷新数据
     */
    public void upData() {
        userList.clear();
        for (int i = 0; i < 30; i++) {
            userList.add(new User("AAAAA" + i, "BBBBB" + i));
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InnerVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_adapter_db_layout, parent, false);
        return new InnerVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerVH holder, int position) {
        holder.setData(userList.get(position));
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class InnerVH extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public InnerVH(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void setData(User user) {
            binding.setVariable(BR.shark, user);
        }

    }
}
