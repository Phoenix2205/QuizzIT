package com.example.sony.quizz.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.example.sony.quizz.R;

import Model.GlobalApplication;

public class Sign_In extends AppCompatActivity {

    private FloatingActionButton mDoneFab;
    EditText firstName;



    private void removeDoneFab(@Nullable Runnable endAction) {
        ViewCompat.animate(mDoneFab)
                .scaleX(0)
                .scaleY(0)
                .setInterpolator(new FastOutSlowInInterpolator())
                .withEndAction(endAction)
                .start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        firstName = (EditText) findViewById(R.id.et_firstname);

        mDoneFab = (FloatingActionButton) findViewById(R.id.done);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // hiding the floating action button if text is empty

            }

            @Override
            public void afterTextChanged(Editable s) {
                // showing the floating action button if avatar is selected and input data is valid
                mDoneFab.show();

            }
        };


        firstName.addTextChangedListener(textWatcher);


        mDoneFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String fname=firstName.getText().toString();

                if (fname.isEmpty()==false    )
                    removeDoneFab(new Runnable() {
                    @Override
                    public void run() {

                            Intent intent = new Intent(Sign_In.this, Welcome.class);
                            String fName = firstName.getText().toString();
                            asignToGlobalApp(fName);
                            startActivity(intent);

                    }
                });
            }
        });
    }

    void asignToGlobalApp(String fname)
    {
        ((GlobalApplication)this.getApplication()).setName(fname);
    }
}






