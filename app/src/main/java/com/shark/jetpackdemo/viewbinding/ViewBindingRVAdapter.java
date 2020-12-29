package com.shark.jetpackdemo.viewbinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shark.jetpackdemo.databinding.ItemAdapterVbLayoutBinding;

/**
 * author : 三丰
 * date   : 2020/12/29
 * desc   :
 */
public class ViewBindingRVAdapter extends RecyclerView.Adapter<ViewBindingRVAdapter.InnerViewHolder> {

    @NonNull
    @Override
    public InnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @NonNull ItemAdapterVbLayoutBinding binding = ItemAdapterVbLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new InnerViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull InnerViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public static class InnerViewHolder extends RecyclerView.ViewHolder {

        public InnerViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
