package com.example.sony.quizz.Activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sony.quizz.R;

import Helper.SoundPoolAssistant;
import Model.GlobalApplication;

public class Welcome extends AppCompatActivity implements View.OnClickListener {

    Button btnPLay;
    Button btnSetting;
    Button btnSignout;
    Button btnExit;
    TextView tvUserName;
    private SoundPoolAssistant mSoundPool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        OnMap();

        btnPLay.setOnClickListener(this);
        btnSetting.setOnClickListener(this);
        btnSignout.setOnClickListener(this);
        btnExit.setOnClickListener(this);
        String fName = ((GlobalApplication)this.getApplication()).getName();
        tvUserName.setText(fName);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.backgroundmusicmp3
        );
        mp.start();
    }

    private void OnMap()
    {
        btnPLay=(Button) findViewById(R.id.button_play);
        btnSetting=(Button) findViewById(R.id.button_setting);
        btnSignout=(Button) findViewById(R.id.button_signout);
        btnExit=(Button) findViewById(R.id.button_exit);
        tvUserName=(TextView)findViewById(R.id.textview_welcome_user_name);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_play:
            {
                Intent intent= new Intent(Welcome.this,Level_Selection.class);
                startActivity(intent);
                break;
            }
            case R.id.button_exit:
            {
                this.finishAffinity();
                break;
            }

            case R.id.button_signout:
            {
                Intent intent= new Intent(Welcome.this,Sign_In.class);
                startActivity(intent);
                break;
            }

        }


    }
}
