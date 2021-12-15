package com.example.myapplication3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultVote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultvote);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteCount = intent.getIntArrayExtra("voteCount");
        String[] imgName = intent.getStringArrayExtra("imgName");

        TextView tv[] = new TextView[imgName.length];
        RatingBar rbar[] = new RatingBar[imgName.length];
        Integer tvID[] = { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
        Integer rbarID[] = { R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9 };

        for (int i=0; i<voteCount.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }
        for (int i=0; i<voteCount.length; i++) {
            tv[i].setText(imgName[i]);
            rbar[i].setRating((float) voteCount[i]);
        }
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}