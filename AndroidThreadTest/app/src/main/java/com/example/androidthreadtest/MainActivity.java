package com.example.androidthreadtest;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    public static final int UPDATE_TEXT = 1;
    private Handler handler = new Handler(){
        public void  handleMessage(Message msg){
            switch (msg.what){
                case UPDATE_TEXT:
                    textView.setText("nice to see you");
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        Button changetext = (Button) findViewById(R.id.change_text);
        changetext.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                       Message message = new Message();
                       message.what = UPDATE_TEXT;
                       handler.sendMessage(message);
                    }
                }).start();
                break;
            default:
                break;
        }
    }
}