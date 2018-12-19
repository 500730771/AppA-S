package com.example.melanie.appaens.activity;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Observatie;

import java.util.Date;

public class StartActivity extends AppCompatActivity {

    private String client;
    private String observator;
    private String datum;
    private String email;
    private boolean video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ActionBar toolbar = getSupportActionBar();
        toolbar.setDisplayHomeAsUpEnabled(true);
        toolbar.setTitle("Checklist");

        EditText mObservator = (EditText) findViewById(R.id.idStart_naamobservator);
        EditText mClient = (EditText) findViewById(R.id.idStart_naamclient);
        EditText mDatum= (EditText) findViewById(R.id.idStart_datum);
        EditText mEmail= (EditText) findViewById(R.id.idStart_email);

        client = mClient.getText().toString();
        observator = mObservator.getText().toString();
        datum = mDatum.getText().toString();
        email = mEmail.getText().toString();

        final RadioButton rClient = (RadioButton) findViewById(R.id.idStart_radioclient);
        final RadioButton rVideo = (RadioButton) findViewById(R.id.idStart_radioVideo);
        
        final DataSource data = new DataSource();
        data.clearData();

        Observatie observatie = new Observatie(client, observator, datum, video);
        data.setObservatie(observatie);

        Button mVerder = (Button) findViewById(R.id.idStart_button);
        mVerder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rClient.isChecked()){
                    video = false;
                } else if (rVideo.isChecked())
                    video = true;
                data.setData(video);
                startActivity(new Intent(StartActivity.this, ScrollMenuActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

    }

    //transition overrides
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_right, R.anim.right_left);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
