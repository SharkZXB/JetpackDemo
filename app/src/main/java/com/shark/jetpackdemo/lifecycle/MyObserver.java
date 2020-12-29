package com.shark.jetpackdemo.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

/**
 * author : 三丰
 * date   : 2020/12/29
 * desc   :
 */
public class MyObserver implements LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        log("onCreate()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        log("onStart()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        log("onResume()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        log("onPause()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        log("onStop()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        log("onDestroy()");
    }


    /**
     * 日志输出
     *
     * @param msg
     */
    private void log(String msg) {
        Log.i("MyObserver", "log: --->" + msg);
    }

}
