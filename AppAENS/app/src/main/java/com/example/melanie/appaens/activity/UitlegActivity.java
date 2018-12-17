package com.example.melanie.appaens.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.data.DataSource;

public class UitlegActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uitleg);

        DataSource data = new DataSource();

        Button mVerder = (Button) findViewById(R.id.idUitleg_verder);

        mVerder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UitlegActivity.this, StartActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });
    }
}