package com.example.melanie.appaens.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.melanie.appaens.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mVerder = (Button) findViewById(R.id.idHome_button);

        mVerder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startActivity = new Intent(MainActivity.this, StartActivity.class);
//                MainActivity.this.st(StartActivity);
//                overridePendingTransition(R.anim.enter, R.anim.exit);

                startActivity(new Intent(MainActivity.this, StartActivity.class));
            }
        });
    }
}
