package com.example.melanie.appaens.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Informatie;
import com.example.melanie.appaens.model.Question;
import com.example.melanie.appaens.model.Score;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdviesActivity extends AppCompatActivity {

    private Button mAfrondenChecklist;

    private Button mButton0;
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;

    private ImageView mImage0;
    private ImageView mImage1;
    private ImageView mImage2;
    private ImageView mImage3;
    private ImageView mImage4;
    private ImageView mImage5;
    private ImageView mImage6;

    private List<Informatie> mInformatieList;
    private Drawable arrowDown;
    private Drawable arrowUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advies);
        Log.d("ADVIESACTIVITY","ADVIESPAGINA");

        ActionBar toolbar = getSupportActionBar();
        toolbar.setTitle("Advies");

        mAfrondenChecklist = (Button) findViewById(R.id.idAdvies_afronden);

        mButton0 = (Button) findViewById(R.id.idAdvies_Button0);
        mButton1 = (Button) findViewById(R.id.idAdvies_Button1);
        mButton2 = (Button) findViewById(R.id.idAdvies_Button2);
        mButton3 = (Button) findViewById(R.id.idAdvies_Button3);
        mButton4 = (Button) findViewById(R.id.idAdvies_Button4);
        mButton5 = (Button) findViewById(R.id.idAdvies_Button5);
        mButton6 = (Button) findViewById(R.id.idAdvies_Button6);

        mImage0 = (ImageView) findViewById(R.id.idAdvies_Image0);
        mImage1 = (ImageView) findViewById(R.id.idAdvies_Image1);
        mImage2 = (ImageView) findViewById(R.id.idAdvies_Image2);
        mImage3 = (ImageView) findViewById(R.id.idAdvies_Image3);
        mImage4 = (ImageView) findViewById(R.id.idAdvies_Image4);
        mImage5 = (ImageView) findViewById(R.id.idAdvies_Image5);
        mImage6 = (ImageView) findViewById(R.id.idAdvies_Image6);

        DataSource data = new DataSource();
        int[] colorList = data.getColors();
        int[] adviesList = data.getAdviesImages();
        mInformatieList = data.getInformatieList();

        List<Score> scores = new ArrayList<Score>();
        String[] textlijst = {"Negatief Overspannen","Negatief Gespannen","Negatief Licht Gespannen","Neutraal / Ontspannen","Positief Licht Gespannen","Positief Gespannen","Positief Overspannen"};

        for (int i = 0; i < 7; i++){
            List<Question> list = data.getQuestionListCategorie(i);
            scores.add(new Score(i, data.getScoreButton(i+1), textlijst[i] + " (" + data.getScoreButton(i+1) +")"));
        }

        for (Score s : scores){
            Log.d("ADVIESACTIVITY","Button: " + s.getButtonId()+", Score: " + s.getScore());
        }
        Collections.sort(scores, Score.compareScore);

        for (Score s : scores){
            Log.d("ADVIESACTIVITY","Button: " +s.getButtonId()+", Score: " + s.getScore());
        }

        //@android:drawable/arrow_down_float

        //set button and image and color
        mButton0.setBackgroundColor(ContextCompat.getColor(this, colorList[scores.get(0).getButtonId()]));
        mButton0.setText(scores.get(0).getText()+"\t");
        mImage0.setImageResource(adviesList[scores.get(0).getButtonId()]);

        mButton1.setBackgroundColor(ContextCompat.getColor(this, colorList[scores.get(1).getButtonId()]));
        mButton1.setText(scores.get(1).getText()+"\t");
        mImage1.setImageResource(adviesList[scores.get(1).getButtonId()]);

        mButton2.setBackgroundColor(ContextCompat.getColor(this, colorList[scores.get(2).getButtonId()]));
        mButton2.setText(scores.get(2).getText()+"\t");
        mImage2.setImageResource(adviesList[scores.get(2).getButtonId()]);

        mButton3.setBackgroundColor(ContextCompat.getColor(this, colorList[scores.get(3).getButtonId()]));
        mButton3.setText(scores.get(3).getText()+"\t");
        mImage3.setImageResource(adviesList[scores.get(3).getButtonId()]);

        mButton4.setBackgroundColor(ContextCompat.getColor(this, colorList[scores.get(4).getButtonId()]));
        mButton4.setText(scores.get(4).getText()+"\t");
        mImage4.setImageResource(adviesList[scores.get(4).getButtonId()]);

        mButton5.setBackgroundColor(ContextCompat.getColor(this, colorList[scores.get(5).getButtonId()]));
        mButton5.setText(scores.get(5).getText()+"\t");
        mImage5.setImageResource(adviesList[scores.get(5).getButtonId()]);

        mButton6.setBackgroundColor(ContextCompat.getColor(this, colorList[scores.get(6).getButtonId()]));
        mButton6.setText(scores.get(6).getText()+"\t");
        mImage6.setImageResource(adviesList[scores.get(6).getButtonId()]);

        //click verder button
        mAfrondenChecklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdviesActivity.this, BedanktActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });


        //click button
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage0.getVisibility()== View.GONE){
                    mImage0.setVisibility(View.VISIBLE);
                    mButton0.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_up2, 0, 0, 0);
                } else {
                    mImage0.setVisibility(View.GONE);
                    mButton0.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down2, 0, 0, 0);
                }
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage1.getVisibility()== View.GONE){
                    mImage1.setVisibility(View.VISIBLE);
                    mButton1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_up2, 0, 0, 0);
                } else {
                    mImage1.setVisibility(View.GONE);
                    mButton1.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down2, 0, 0, 0);
                }
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage2.getVisibility()== View.GONE){
                    mImage2.setVisibility(View.VISIBLE);
                    mButton2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_up2, 0, 0, 0);
                } else {
                    mImage2.setVisibility(View.GONE);
                    mButton2.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down2, 0, 0, 0);
                }
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage3.getVisibility()== View.GONE){
                    mImage3.setVisibility(View.VISIBLE);
                    mButton3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_up2, 0, 0, 0);
                } else {
                    mImage3.setVisibility(View.GONE);
                    mButton3.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down2, 0, 0, 0);
                }
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage4.getVisibility()== View.GONE){
                    mImage4.setVisibility(View.VISIBLE);
                    mButton4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_up2, 0, 0, 0);
                } else {
                    mImage4.setVisibility(View.GONE);
                    mButton4.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down2, 0, 0, 0);
                }
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage5.getVisibility()== View.GONE){
                    mImage5.setVisibility(View.VISIBLE);
                    mButton5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_up2, 0, 0, 0);
                } else {
                    mImage5.setVisibility(View.GONE);
                    mButton5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down2, 0, 0, 0);
                }
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage6.getVisibility()== View.GONE){
                    mImage6.setVisibility(View.VISIBLE);
                    mButton6.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_up2, 0, 0, 0);
                } else {
                    mImage6.setVisibility(View.GONE);
                    mButton6.setCompoundDrawablesWithIntrinsicBounds(R.drawable.arrow_down2, 0, 0, 0);
                }
            }
        });

        LinearLayout mBoxred = (LinearLayout) findViewById(R.id.idInformatie_boxred);
        LinearLayout mBoxorange = (LinearLayout) findViewById(R.id.idInformatie_boxorange);
        LinearLayout mBoxyellow = (LinearLayout) findViewById(R.id.idInformatie_boxyellow);
        LinearLayout mBoxblue = (LinearLayout) findViewById(R.id.idInformatie_boxblue);
        LinearLayout mBoxgreen = (LinearLayout) findViewById(R.id.idInformatie_boxgreen);
        LinearLayout mBoxpink = (LinearLayout) findViewById(R.id.idInformatie_boxpink);
        LinearLayout mBoxpurple = (LinearLayout) findViewById(R.id.idInformatie_boxpurple);

        mBoxred.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviesActivity.this, Popup.class);
                intent.putExtra("Informatie", mInformatieList.get(0));
                startActivity(intent);
                overridePendingTransition(R.anim.from_below, R.anim.to_below);
            }
        });
        mBoxorange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviesActivity.this, Popup.class);
                intent.putExtra("Informatie", mInformatieList.get(1));
                startActivity(intent);
                overridePendingTransition(R.anim.from_below, R.anim.to_below);
            }
        });
        mBoxyellow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviesActivity.this, Popup.class);
                intent.putExtra("Informatie", mInformatieList.get(2));
                startActivity(intent);
                overridePendingTransition(R.anim.from_below, R.anim.to_below);
            }
        });
        mBoxblue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviesActivity.this, Popup.class);
                intent.putExtra("Informatie", mInformatieList.get(3));
                startActivity(intent);overridePendingTransition(R.anim.from_below, R.anim.to_below);
            }
        });
        mBoxgreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviesActivity.this, Popup.class);
                intent.putExtra("Informatie", mInformatieList.get(4));
                startActivity(intent);overridePendingTransition(R.anim.from_below, R.anim.to_below);
            }
        });
        mBoxpink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviesActivity.this, Popup.class);
                intent.putExtra("Informatie", mInformatieList.get(5));
                startActivity(intent);overridePendingTransition(R.anim.from_below, R.anim.to_below);
            }
        });
        mBoxpurple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdviesActivity.this, Popup.class);
                intent.putExtra("Informatie", mInformatieList.get(6));
                startActivity(intent);overridePendingTransition(R.anim.from_below, R.anim.to_below);
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (true) {
            //do nothing
        } else {
            super.onBackPressed();
        }
    }
}
