package com.example.melanie.appaens.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.melanie.appaens.R;

public class ScrollMenuActivity extends AppCompatActivity {

    private ListView menuList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_menu);

        menuList = (ListView) findViewById(R.id.idMenu_list);

    }
}
