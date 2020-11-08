package com.example.Admin.whowantstobemillionaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q4 extends AppCompatActivity {

    private TextView Earned, question, confirm;
    private RadioButton Answer1, Answer2, Answer3, Answer4;
    private int total, qq=4;

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
        question.setText(qq+"What to bear mainly do in ameican, to peoples bins?");
        Answer1.setText("Scavange for food");
        Answer2.setText("Try wreck the bin");
        Answer3.setText("Try make a mess");
        Answer4.setText("Eat food wrappers");
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
            Toast.makeText(Q4.this, "This is the Correct answer \n you earned $"+1000, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Q4.this, Q5.class);
            intent.putExtra("Earnings", total); // earnings on next activity
            startActivity(intent); }
        else
        { Toast.makeText(Q4.this, "False Answer", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Q4.this, Lose.class);
            intent.putExtra("Earnings", total+0);
            startActivity(intent);
        } }}

