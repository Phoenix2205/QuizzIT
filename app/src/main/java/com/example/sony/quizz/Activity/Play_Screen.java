package com.example.sony.quizz.Activity;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sony.quizz.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import Helper.DataGetter;
import Helper.DatabaseHelper;
import Helper.SoundPoolAssistant;
import Model.GlobalApplication;
import Model.Player;
import Model.QuestionLevel;
import Model.Selected;
import Model.Test;

public class Play_Screen extends AppCompatActivity implements View.OnClickListener {
    private int mQuizSize = 10;
    private TextView mQuizView;// quiz sixe
    private TextView mProgressText; // diem
    private TextView mToolBarTitle;
    private ProgressBar mProgressBar;//progress
    Button A, B, C, D;
    int currentPos = 0;
    int score=0;
    DataGetter dataGetter;
    String dataLevel;
    Toolbar toolbar;
    private SoundPoolAssistant mSoundPool;
    ArrayList<Test>tests= new ArrayList<>();
    DatabaseHelper databaseHelper;
    ArrayList<Selected>selectedList=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_screen);
        onMapped();

        A.setOnClickListener(this);
        B.setOnClickListener(this);
        C.setOnClickListener(this);
        D.setOnClickListener(this);

        loadAudio();
        showNextPage(dataLevel);

    }

    private void setProgressPlay(int currentQuizPosition) {
        mProgressText.setText(getString(R.string.quiz_of_quizzes, currentQuizPosition, mQuizSize));
        mProgressBar.setProgress(currentQuizPosition-1);
    }

    private boolean showNextPage(String level) {

        switch (level) {
            case "Easy Mode":{
                if (tests.size()==0)
                        tests = createTest(dataGetter.mucDe);
                //                       chi de kiem tra random xuat macauhoi va cau hoi
                String question = dataGetter.dsch.get(tests.get(currentPos).macauhoi - 1).Ma + "/ "
                        + dataGetter.dsch.get(tests.get(currentPos).macauhoi - 1).Cauhoi;
                mQuizView.setText(question);

                String answerA = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauA;
                String answerB = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauB;
                String answerC = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauC;
                String answerD = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauD;

                // hoan vi cau tra loi
                if (dataGetter.dsch.get(tests.get(currentPos).macauhoi - 1).Hoanvi == 1) {
                    String[] answer = new String[4];
                    int[] temp = new int[4];
                    Random random = new Random();
                    for (int i = 0; i < temp.length; i++) {
                        int value = random.nextInt(4);
                        boolean succeed = insertValueIntoArr(value, temp, i);
                        while (succeed == false) {
                            value = random.nextInt(4);
                            succeed = insertValueIntoArr(value, temp, i);
                        }
                    }

                    answer[temp[0]] = answerA;
                    answer[temp[1]] = answerB;
                    answer[temp[2]] = answerC;
                    answer[temp[3]] = answerD;

                    showAnswer(answer[0], A);
                    showAnswer(answer[1], B);
                    showAnswer(answer[2], C);
                    showAnswer(answer[3], D);
                } else {
                    showAnswer(answerA, A);
                    showAnswer(answerB, B);
                    showAnswer(answerC, C);
                    showAnswer(answerD, D);
                }
                break;
            }

            case"Medium Mode": {
                if (tests.size() == 0)
                    tests = createTest(dataGetter.mucTB);
                //                       chi de kiem tra random xuat macauhoi va cau hoi
                String question = dataGetter.dsch.get(tests.get(currentPos).macauhoi - 1).Ma + "/ "
                        + dataGetter.dsch.get(tests.get(currentPos).macauhoi - 1).Cauhoi;
                mQuizView.setText(question);

                String answerA = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauA;
                String answerB = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauB;
                String answerC = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauC;
                String answerD = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauD;

                // hoan vi cau tra loi
                if (dataGetter.dsch.get(tests.get(currentPos).macauhoi - 1).Hoanvi == 1) {
                    String[] answer = new String[4];
                    int[] temp = new int[4];
                    Random random = new Random();
                    for (int i = 0; i < temp.length; i++) {
                        int value = random.nextInt(4);
                        boolean succeed = insertValueIntoArr(value, temp, i);
                        while (succeed == false) {
                            value = random.nextInt(4);
                            succeed = insertValueIntoArr(value, temp, i);
                        }
                    }

                    answer[temp[0]] = answerA;
                    answer[temp[1]] = answerB;
                    answer[temp[2]] = answerC;
                    answer[temp[3]] = answerD;

                    showAnswer(answer[0], A);
                    showAnswer(answer[1], B);
                    showAnswer(answer[2], C);
                    showAnswer(answer[3], D);
                } else {
                    showAnswer(answerA, A);
                    showAnswer(answerB, B);
                    showAnswer(answerC, C);
                    showAnswer(answerD, D);
                }
                break;
            }
            default:{
                if (tests.size() == 0)
                    tests = createTest(dataGetter.mucKho);
                //                       chi de kiem tra random xuat macauhoi va cau hoi
                String question = dataGetter.dsch.get(tests.get(currentPos).macauhoi - 1).Ma + "/ "
                        + dataGetter.dsch.get(tests.get(currentPos).macauhoi - 1).Cauhoi;
                mQuizView.setText(question);

                String answerA = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauA;
                String answerB = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauB;
                String answerC = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauC;
                String answerD = dataGetter.dsda.get(tests.get(currentPos).macauhoi - 1).CauD;

                // hoan vi cau tra loi
                if (dataGetter.dsch.get(tests.get(currentPos).macauhoi - 1).Hoanvi == 1) {
                    String[] answer = new String[4];
                    int[] temp = new int[4];
                    Random random = new Random();
                    for (int i = 0; i < temp.length; i++) {
                        int value = random.nextInt(4);
                        boolean succeed = insertValueIntoArr(value, temp, i);
                        while (succeed == false) {
                            value = random.nextInt(4);
                            succeed = insertValueIntoArr(value, temp, i);
                        }
                    }

                    answer[temp[0]] = answerA;
                    answer[temp[1]] = answerB;
                    answer[temp[2]] = answerC;
                    answer[temp[3]] = answerD;

                    showAnswer(answer[0], A);
                    showAnswer(answer[1], B);
                    showAnswer(answer[2], C);
                    showAnswer(answer[3], D);
                } else {
                    showAnswer(answerA, A);
                    showAnswer(answerB, B);
                    showAnswer(answerC, C);
                    showAnswer(answerD, D);
                }
            break;
            }
        }
        return true;
    }





    private boolean insertValueIntoArr(int value, int[] temp, int pos) {
        for (int i=0;i<pos;i++)
            if (temp[i]==value) return false;
        temp[pos]=value;
        return true;
    }

    private boolean insertValueIntoArr1(int value, int[] arr, int pos)
    {
        int [] temp=new int[arr.length];
        for (int i=0;i<temp.length;i++)
            temp[i]=arr[i];
        Arrays.sort(temp);
        if (Arrays.binarySearch(temp,value)>=0) return false;
        arr[pos]=value;
        return true;
    }

    private void showAnswer(String answer, Button btn) {
        if (answer.isEmpty()) btn.setVisibility(View.INVISIBLE);
        else
        {
            btn.setVisibility(View.VISIBLE);
            btn.setText(answer);
        }
    }

    private ArrayList<Test> createTest(ArrayList<QuestionLevel> level) {
        ArrayList<Test>temp= new ArrayList<Test>();

        int [] quesNum= new int[mQuizSize];

        Random random= new Random();
            for (int pos = 0; pos < mQuizSize; pos++) {
                {
                    int values=level.get(0).macauhoi + random.nextInt(level.get(level.size() - 1).macauhoi - level.get(0).macauhoi + 1);
                    boolean succeed = insertValueIntoArr1(values,quesNum,pos);
                    while (succeed==false)
                    {
                        values=level.get(0).macauhoi + random.nextInt(level.get(level.size() - 1).macauhoi - level.get(0).macauhoi + 1);
                        succeed = insertValueIntoArr1(values,quesNum,pos);
                    }
                }
            }


        for (int y =0;y<quesNum.length;y++)
        {
            int question_number=quesNum[y];
            Test test= new Test(y,question_number);
            temp.add(test);
        }


        return  temp;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_A: {
                check(currentPos,A);
                break;
            }
            case R.id.btn_B: {
                check(currentPos,B);
                break;
            }
            case R.id.btn_C: {
                check(currentPos,C);
                break;
            }
            case R.id.btn_D: {
                check(currentPos,D);
                break;
            }

        }
        setProgressPlay(currentPos+1);
        if (currentPos<mQuizSize-1)
        { currentPos++;
        showNextPage(dataLevel);}
        else
        {

            ((GlobalApplication)this.getApplication()).setSelectedList(selectedList);
            String userName=getIntent().getStringExtra("fName");
            Player player = new Player(userName,score);
            databaseHelper.insertPlayerIntoDB(player);
            Intent intent =new Intent(Play_Screen.this,Score.class);
            intent.putExtra("score",score);
            startActivity(intent);
        }
    }

    private void check(int currentPos, Button btn) {
        String selected=btn.getText().toString().trim();
        String result=dataGetter.dsch.get(tests.get(currentPos).macauhoi-1).CauTL.trim();
        if (selected.equals(result)==true) {
            Toast.makeText(this,"Correct",Toast.LENGTH_SHORT);
            Selected chosenAnswer= new Selected(1,selected);
            selectedList.add(chosenAnswer);
            mSoundPool.play(R.raw.correct);
            score++;
        }
        else
        {
            Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT);
            Selected chosenAnswer= new Selected(0,selected);
            selectedList.add(chosenAnswer);
            mSoundPool.play(R.raw.incorrect);
        }
    }

    private void loadAudio() {
        mSoundPool = new SoundPoolAssistant(this, 1, AudioManager.STREAM_MUSIC);
        mSoundPool.load(R.raw.correct);
        mSoundPool.load(R.raw.incorrect);

    }

    private void onMapped()
    {
        mToolBarTitle=(TextView)findViewById(R.id.title);
        mQuizView = (TextView) findViewById(R.id.quiz_view);
        mQuizView.setMovementMethod(new ScrollingMovementMethod());
        mProgressText = (TextView) findViewById(R.id.progress_text);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
        mProgressBar.setMax(mQuizSize-1);

        toolbar=(Toolbar)findViewById(R.id.tool_bar_play);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        databaseHelper = new DatabaseHelper(this);
        dataGetter = new DataGetter(databaseHelper);

        dataLevel = getIntent().getStringExtra("level");
        mToolBarTitle.setText(dataLevel);
        A = (Button) findViewById(R.id.btn_A);
        B = (Button) findViewById(R.id.btn_B);
        C = (Button) findViewById(R.id.btn_C);
        D = (Button) findViewById(R.id.btn_D);

    }


}
