package com.shark.jetpackdemo.livedata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.shark.jetpackdemo.databinding.ActivityLiveDataBinding;

/**
 *
 */
public class LiveDataActivity extends AppCompatActivity {

    private NameViewModel model;
    private ActivityLiveDataBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityLiveDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Get the ViewModel.
        model = new ViewModelProvider(this).get(NameViewModel.class);

        // TODO 2.观察 LiveData 对象
        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                binding.tvName.setText(newName);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.getCurrentName().observe(this, nameObserver);

    }

    /**
     * @param view
     */
    public void onUpDataClick(View view) {
        // TODO 3.更新 LiveData 对象
        // 注意：您必须调用 setValue(T) 方法以从主线程更新 LiveData 对象。
        // 如果在 worker 线程中执行代码，则您可以改用 postValue(T) 方法来更新 LiveData 对象。
        model.getCurrentName().setValue("123");
    }
}