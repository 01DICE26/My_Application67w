package com.example.myapplication67w;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private TextView timerText;
    private Button dispatchButton, endDispatchButton;
    private boolean isRunning = false;
    private long startTime = 0L;
    private Button pin;
    private Handler timerHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML 뷰와 연결
        timerText = findViewById(R.id.timerText);
        dispatchButton = findViewById(R.id.dispatchButton);
        endDispatchButton = findViewById(R.id.endDispatchButton);\
        pin = findViewById(R.id.pin);

        // 출동 버튼 클릭 이벤트 - 타이머 시작
        dispatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isRunning) {
                    startTime = SystemClock.uptimeMillis();
                    timerHandler.postDelayed(timerRunnable, 0);
                    isRunning = true;
                }
            }
        });


        pin.setOnClickListener(v ->{
            Intent intent = new Intent
        });




        // 출동 종료 버튼 클릭 이벤트 - 타이머 멈춤
        endDispatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunning) {
                    timerHandler.removeCallbacks(timerRunnable);
                    isRunning = false;
                }
            }
        });
    }

    // 타이머 실행을 위한 Runnable 객체
    private Runnable timerRunnable = new Runnable() {
        @Override
        public void run() {
            long elapsedMillis = SystemClock.uptimeMillis() - startTime;
            timerText.setText(String.format("⏳ 소요 시간: %.1f 초", elapsedMillis / 1000.0));
            timerHandler.postDelayed(this, 100);
        }
    };
}
