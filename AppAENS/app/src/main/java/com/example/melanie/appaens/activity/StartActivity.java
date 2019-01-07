package com.example.melanie.appaens.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
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

        final EditText mObservator = (EditText) findViewById(R.id.idStart_naamobservator);
        final EditText mClient = (EditText) findViewById(R.id.idStart_naamclient);
        final EditText mDatum= (EditText) findViewById(R.id.idStart_datum);
        final EditText mEmail= (EditText) findViewById(R.id.idStart_email);

        final RadioButton rClient = (RadioButton) findViewById(R.id.idStart_radioclient);
        final RadioButton rVideo = (RadioButton) findViewById(R.id.idStart_radioVideo);
        
        final DataSource data = new DataSource();
        data.clearData();

        Observatie o = data.getObservatie();
        if (o != null){
            mObservator.setText(o.getObservator());
            mClient.setText(o.getClient());
            mDatum.setText(o.getDatum());
            mEmail.setText(o.getEmail());
        }

        Button mVerder = (Button) findViewById(R.id.idStart_button);
        mVerder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation(mObservator, mClient, mDatum, mEmail)) {
                    if (rClient.isChecked()) {
                        video = false;
                    } else if (rVideo.isChecked())
                        video = true;
                    Observatie observatie = new Observatie(mClient.getText().toString(),
                            mObservator.getText().toString(), mDatum.getText().toString(), video, mEmail.getText().toString());
                    data.setObservatie(observatie);
                    data.setData(video);

                    startActivity(new Intent(StartActivity.this, ScrollMenuActivity.class));
                    overridePendingTransition(R.anim.enter, R.anim.exit);
                } else {
                    new AlertDialog.Builder(StartActivity.this)
                            .setMessage("Niet alle velden zijn ingevuld.")
                            .setCancelable(false)
                            .setNegativeButton("Terug", null)
                            .show();
                }
            }
        });
    }

    public boolean validation(EditText one, EditText two, EditText three, EditText four){
//        if (one.getText().toString().matches("") || two.getText().toString().matches("")
//                || three.getText().toString().matches("") || four.getText().toString().matches(""))
//            return false;
        return true;
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
