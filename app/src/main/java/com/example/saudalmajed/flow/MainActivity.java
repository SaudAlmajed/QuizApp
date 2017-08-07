package com.example.saudalmajed.flow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView result;
    private EditText answerQ1, answerQ2;
    private RadioButton Q3T, Q3F;
    private CheckBox Q4T1, Q4T2, Q4F;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Q3T = (RadioButton) findViewById(R.id.Q3True);
        Q3F = (RadioButton) findViewById(R.id.Q3False);
        RadioGroup radioGroup = new RadioGroup(this);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton checked = (RadioButton) view;
                if (Q3T.getId() == checked.getId()) {
                    Q3T.setChecked(true);
                    Q3F.setChecked(false);
                } else if (Q3F.getId() == checked.getId()) {
                    Q3F.setChecked(true);
                    Q3T.setChecked(false);
                }

            }
        };
        Q3T.setOnClickListener(listener);
        Q3F.setOnClickListener(listener);


        result = (TextView) findViewById(R.id.score);
        answerQ1 = (EditText) findViewById(R.id.answerQ1);
        answerQ2 = (EditText) findViewById(R.id.answerQ2);


        Q4T1 = (CheckBox) findViewById(R.id.Q4True1);
        Q4T2 = (CheckBox) findViewById(R.id.Q4True2);
        Q4F = (CheckBox) findViewById(R.id.Q4False);


    }


    public void submit(View v) {

        score = 0;
        Toast.makeText(this, "Suceses", Toast.LENGTH_LONG);

        if (answerQ1.getText().toString().trim().toLowerCase().equals("africa"))
            score++;
        else
            score = 0;

        if (answerQ2.getText().toString().equals("40"))
            score++;
        if (Q3T.isChecked())
            score++;
        if (Q4T1.isChecked() && Q4T2.isChecked() && Q4F.isChecked() != true)
            score++;

        result.setText("The score is " + score + " of 4");
        result.setVisibility(View.VISIBLE);

    }
}
