package com.shark.jetpackdemo.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 * author : 三丰
 * date   : 2020/12/29
 * desc   : 创建一个LiveData 存放在 ViewModel 里面
 */
public class NameViewModel extends ViewModel {

    // TODO 1.创建 LiveData 对象
    // Create a LiveData with a String
    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName() {
        if (currentName == null) {
            currentName = new MutableLiveData<String>();
        }
        return currentName;
    }

}
