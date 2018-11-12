package com.example.melanie.appaens.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.model.Observatie;

import java.util.Date;

public class StartActivity extends AppCompatActivity {

    private String client;
    private String observator;
    private String datum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        EditText mObservator = (EditText) findViewById(R.id.idStart_observator);
        EditText mClient = (EditText) findViewById(R.id.idStart_naamclient);
        EditText mDatum= (EditText) findViewById(R.id.idStart_datum);

        client = mClient.getText().toString();
        observator = mObservator.getText().toString();
        datum = mDatum.getText().toString();

        Observatie observatie = new Observatie(client, observator, datum, false);

        Button mVerder = (Button) findViewById(R.id.idStart_button);

        mVerder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StartActivity.this, ScrollMenuActivity.class));
            }
        });

    }
}
