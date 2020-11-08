package com.example.Admin.whowantstobemillionaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q6 extends AppCompatActivity {
    private TextView Earned, question, confirm;
    private RadioButton Answer1, Answer2, Answer3, Answer4;
    private int total, qq=6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question1);

        Earned = (TextView) findViewById(R.id.earnings);
        question = (TextView) findViewById(R.id.q1);
        confirm = (TextView) findViewById(R.id.confirm);
        Answer1 = (RadioButton) findViewById(R.id.A1);
        Answer2 = (RadioButton) findViewById(R.id.A2);
        Answer3 = (RadioButton) findViewById(R.id.A3);
        Answer4 = (RadioButton) findViewById(R.id.A4);
        total = getIntent().getIntExtra("Earnings", 0);;


        setData();

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                next(); // next() function called
            }
        }); }

    private void setData()
    {
        Earned.setText("You Earned $"+total);
        question.setText(qq+"Which of the following is there more of on Earth?");
        Answer1.setText("Plankton");
        Answer2.setText("cats");
        Answer3.setText("Human");
        Answer4.setText("sheep");
    }
    private void next()
    {
        int selected=0;

        boolean b[] = {Answer1.isChecked(), Answer2.isChecked(), Answer3.isChecked(), Answer4.isChecked()} ;

        for (int i=0; i<4; i++)
        {
            if (b[i] == true)
            {
                selected = i+1;
            }}
        if (selected == 1)
        {
            total = total+1000;
            Toast.makeText(Q6.this, "This is the Correct answer \n you earned $"+1000, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Q6.this, Q7.class);
            intent.putExtra("Earnings", total); // earnings on next activity
            startActivity(intent); }
        else
        { Toast.makeText(Q6.this, "False Answer", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Q6.this, Lose.class);
            intent.putExtra("Earnings", total+0);
            startActivity(intent);
        } }}