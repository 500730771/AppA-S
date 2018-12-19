package com.example.melanie.appaens.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.text.IDNA;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.data.DataSource;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar toolbar = getSupportActionBar();
        toolbar.setTitle("A&S");

        Button mVerder = (Button) findViewById(R.id.idHome_button);

        mVerder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, UitlegActivity.class));
                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == (R.id.idMenu_info)) {
            startActivity(new Intent(MainActivity.this, InfoActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
