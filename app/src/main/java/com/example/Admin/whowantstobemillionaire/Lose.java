package com.example.Admin.whowantstobemillionaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lose extends AppCompatActivity {

    TextView Lose;
    private Button restart;
    private Button exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lose);

        Lose = (TextView) findViewById(R.id.lose);
        restart = (Button) findViewById(R.id.restart);
        exit = (Button) findViewById(R.id.exit);

        Lose.setText("Earned $"+ getIntent().getIntExtra("Earnings", 0));

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Lose.this, Q1.class));
            }
        });


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}
