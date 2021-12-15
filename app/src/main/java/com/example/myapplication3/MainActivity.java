package com.example.myapplication3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("2021년 히트친 작품");

        final  int voteCount[] = new int[9];
        for (int i=0; i<9; i++)
            voteCount[i] = 0;

        ImageView image[] = new ImageView[9];
        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3,
                R.id.iv4, R.id.iv5, R.id.iv6, R.id.iv7,
                R.id.iv8, R.id.iv9 };
        final String imgName[] = { "오징어게임",
                "마이네임", "지옥", "D.P.",
                "스위트홈", "무브 투 헤븐", "모가디슈",
                "스트릿 우먼 파이터", "쇼미더머니10" };

        for (int i=0; i<imageId.length; i++) {
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index] + "에 투표하였습니다.",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnResult = (Button) findViewById(R.id.btnResult);
        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),
                        ResultVote.class);
                intent.putExtra("voteCount", voteCount);
                intent.putExtra("imgName", imgName);
                startActivity(intent);
            }
        });
    }
}