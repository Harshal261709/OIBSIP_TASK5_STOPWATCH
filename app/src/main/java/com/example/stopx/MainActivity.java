package com.example.stopx;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView timerText;
    ImageView startbtn,pausebtn,stopbtn;
    //int seconds = 0;
    int milliSeconds = 0;
    boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timerText = findViewById(R.id.timerText);
        startbtn = findViewById(R.id.startbtn);
        pausebtn = findViewById(R.id.pausebtn);
        stopbtn = findViewById(R.id.stopbtn);

        startTimer();

//        public void onClickStart(View view) {
//
//        }
//
//        public void onClickStop(View view) {
//
//        }
//
//        public void onClickReset(View view) {
//
//        }

    }

    public void onClickReset(View view) {
        isRunning = false;
        milliSeconds = 0;
    }

    public void onClickStart(View view) {
        isRunning = true;
    }

    public void onClickStop(View view) {
        isRunning = false;
    }

    public void startTimer() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {


                int s = (milliSeconds/60)%60;
                int mi = milliSeconds%100;
                int m = milliSeconds/3600;
//                int h = m/60; // or seconds/(60*60)

                if (isRunning) {
                    milliSeconds++;
                }


                String formatString = String.format(Locale.getDefault(),"%02d:%02d:%02d", m, s, mi);

                timerText.setText(formatString);
                handler.postDelayed(this, 10);

            }
        };
        handler.post(runnable);
    }

}