package com.example.sony.quizz.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.sony.quizz.R;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

public class Score extends AppCompatActivity {
    SimpleDraweeView image_icon;
    TextView score_view;
    int score;
    FloatingActionButton mDoneFab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        image_icon = (SimpleDraweeView) findViewById(R.id.fresco_iamge_holder);
        score_view=(TextView)findViewById(R.id.text_view_score);
        score=getIntent().getIntExtra("score",0);
        mDoneFab=(FloatingActionButton)findViewById(R.id.finish);
        mDoneFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this,Answer_Statistic.class);
                startActivity(intent);
            }
        });
        displayScore();

    }

    private void displayScore() {
        score_view.setText(Integer.toString(score)+"/10");
        if (score<5)
        {
            Uri uri = new Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                    .path(String.valueOf(R.drawable.sad_emoji))
                    .build();
            image_icon.setImageURI(uri);
        }

        if (score>=5&&score<7)
        {
            Uri uri = new Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                    .path(String.valueOf(R.drawable.nicetry_emoji))
                    .build();
            image_icon.setImageURI(uri);
        }

        if (score>=7)
        {
            Uri uri = new Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                    .path(String.valueOf(R.drawable.goodjob_emoji))
                    .build();
            image_icon.setImageURI(uri);
        }
    }
}
