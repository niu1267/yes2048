package com.example.a2048;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CongratulationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulations);

        // 获取最终分数
        Intent intent = getIntent();
        int finalScore = intent.getIntExtra("finalScore", 0);
        String mode = intent.getStringExtra("mode");

        // 设置最终分数
        TextView finalScoreText = findViewById(R.id.finalScore);
        finalScoreText.setText("最终得分：" + finalScore);

        // 再来一局按钮
        Button replayButton = findViewById(R.id.buttonReplay);
        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 返回主界面并带上模式参数
                Intent replayIntent = new Intent(CongratulationsActivity.this, MainActivity.class);
                replayIntent.putExtra("mode", mode);
                startActivity(replayIntent);
                finish();
            }
        });
    }
}