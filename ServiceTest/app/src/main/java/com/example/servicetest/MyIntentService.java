package com.example.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.d("myintentservice", "thread id is"+Thread.currentThread().getId());


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("myintentservice", "onDestroy executed");
    }
}
