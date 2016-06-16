package com.example.sony.quizz.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.sony.quizz.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import Helper.DatabaseHelper;
import Helper.TopScoreAdapter;
import Model.Player;

public class Top_Score extends AppCompatActivity {
    ArrayList<Player>playerList= new ArrayList<>();
   ArrayList <Player>top5;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    ImageButton replayButton;
    ImageButton exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_score);
        DatabaseHelper databaseHelper= new DatabaseHelper(this);
        playerList=databaseHelper.getUser();
        if (playerList.size()>=10) databaseHelper.DeleteDatafromDatabase("player");

        Collections.sort((playerList), new Comparator<Player>() {
            @Override
            public int compare(Player lhs, Player rhs) {
                Integer num1 = new Integer(lhs.score);
                Integer num2 = new Integer(rhs.score);
                return num1.compareTo(num2);
            }
        });





        recyclerView=(RecyclerView)findViewById(R.id.recycler_view_top_score);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if(playerList.size()<5)
            adapter= new TopScoreAdapter(this,playerList);
        else  {
            top5 = new ArrayList<Player>(playerList.subList((playerList.size() -5) , playerList.size()));
            adapter= new TopScoreAdapter(this,top5);
        }


        recyclerView.setAdapter(adapter);

        replayButton=(ImageButton) findViewById(R.id.image_button_replay);
        exitButton=(ImageButton)findViewById(R.id.image_button_exit);
        replayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Top_Score.this,Level_Selection.class);
                startActivity(intent);
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApplication();
            }
        });


    }

    void exitApplication()
    {
        this.finishAffinity();
    }

}
