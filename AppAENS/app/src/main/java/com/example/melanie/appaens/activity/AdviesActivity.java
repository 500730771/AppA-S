package com.example.melanie.appaens.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.melanie.appaens.R;

public class AdviesActivity extends AppCompatActivity {

    private Button mButtonVerder;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advies);

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


        //set button and image


        //click verder button


        //click button
        mButton0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage0.getVisibility()== View.GONE){
                    mImage0.setVisibility(View.VISIBLE);
                } else {
                    mImage0.setVisibility(View.GONE);
                }
            }
        });
        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage1.getVisibility()== View.GONE){
                    mImage1.setVisibility(View.VISIBLE);
                } else {
                    mImage1.setVisibility(View.GONE);
                }
            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage2.getVisibility()== View.GONE){
                    mImage2.setVisibility(View.VISIBLE);
                } else {
                    mImage2.setVisibility(View.GONE);
                }
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage3.getVisibility()== View.GONE){
                    mImage3.setVisibility(View.VISIBLE);
                } else {
                    mImage3.setVisibility(View.GONE);
                }
            }
        });
        mButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage4.getVisibility()== View.GONE){
                    mImage4.setVisibility(View.VISIBLE);
                } else {
                    mImage4.setVisibility(View.GONE);
                }
            }
        });
        mButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage5.getVisibility()== View.GONE){
                    mImage5.setVisibility(View.VISIBLE);
                } else {
                    mImage5.setVisibility(View.GONE);
                }
            }
        });
        mButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mImage6.getVisibility()== View.GONE){
                    mImage6.setVisibility(View.VISIBLE);
                } else {
                    mImage6.setVisibility(View.GONE);
                }
            }
        });
    }
}
