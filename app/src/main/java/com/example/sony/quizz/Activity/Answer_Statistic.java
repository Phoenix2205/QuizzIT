package com.example.sony.quizz.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sony.quizz.R;

import java.util.ArrayList;

import Helper.SelectedListAdapter;
import Model.GlobalApplication;
import Model.Selected;

public class Answer_Statistic extends AppCompatActivity {
    ArrayList<Selected>selectedList=new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    FloatingActionButton done;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer_statistic);
        selectedList=((GlobalApplication)this.getApplication()).getSelectedList();
        recyclerView=(RecyclerView)findViewById(R.id.recycler_view_container);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter= new SelectedListAdapter(selectedList,this);
        recyclerView.setAdapter(adapter);
        done=(FloatingActionButton)findViewById(R.id.answer_statistic_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Answer_Statistic.this,Top_Score.class);
                startActivity(intent);
            }
        });


    }
}
