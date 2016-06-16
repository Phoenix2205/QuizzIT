package com.example.sony.quizz.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sony.quizz.R;

import Model.GlobalApplication;

public class Level_Selection extends AppCompatActivity implements View.OnClickListener {
    Button btnEasyMode;
    Button btnHardMode;
    Button btnMediumMode;

    String fName ;
    String lName;
    TextView tvWelcom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        tvWelcom= (TextView)findViewById(R.id.title);

        btnEasyMode=(Button)findViewById(R.id.btn_de);
        btnHardMode=(Button)findViewById(R.id.btn_kho);
        btnMediumMode=(Button)findViewById(R.id.btn_tb);

        btnEasyMode.setOnClickListener(this);
        btnHardMode.setOnClickListener(this);
        btnMediumMode.setOnClickListener(this);

        fName = ((GlobalApplication)this.getApplication()).getName();

        Log.d("Firstname",fName);
        tvWelcom.setText("Welcome "+ fName );


    }

    @Override
    public void onClick(View v) {
        String level;
        switch (v.getId())
        {
            case R.id.btn_de:
            {
                level=btnEasyMode.getText().toString();
               StartPlayScreen(level);
                break;
            }
            case R.id.btn_kho:
            {
                level=btnHardMode.getText().toString();
                StartPlayScreen(level);
                break;
            }
            case R.id.btn_tb:
            {
                level=btnMediumMode.getText().toString();
                StartPlayScreen(level);
                break;
            }

        }
    }

    void StartPlayScreen(String level)
    {
        Intent i = new Intent(this, Play_Screen.class);
        i.putExtra("fName",fName);
        i.putExtra("level",level);
        startActivity(i);
    }
}
