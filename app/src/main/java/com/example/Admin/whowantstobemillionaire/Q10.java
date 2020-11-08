package com.example.Admin.whowantstobemillionaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Q10 extends AppCompatActivity {

    private TextView Earned, question, confirm;
    private RadioButton Answer1, Answer2, Answer3, Answer4;
    private int total, qq=10;

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
        question.setText(qq+"If you celebrate something bi-annually, how often do you celebrate it?");
        Answer1.setText("Every two months");
        Answer2.setText("Every two years");
        Answer3.setText("Every three months");
        Answer4.setText("Every three years");
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
            }
        }

        /* If all answers are correct , then win class
            will be called */
        if (selected == 2)
        {
            if (total== 9000)
            {
                total = total+1000;
                Toast.makeText(Q10.this, "This is the Correct answer \n you earned $"+total, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Q10.this, Win.class);
                startActivity(intent);
            }
            else
            {
                total = total+1000;
                Toast.makeText(Q10.this, "This is the Correct answer \n you earned $"+total, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Q10.this, Lose.class);
                intent.putExtra("Earnings", total);
                startActivity(intent);
            } }
        else
        {
            Toast.makeText(Q10.this, "False Answer", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Q10.this, Lose.class);
            intent.putExtra("Earnings", total+0);
            startActivity(intent);
        }
    }
}
