package com.example.melanie.appaens.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.adapter.RecyclerViewAdapter;
import com.example.melanie.appaens.adapter.RecyclerViewInformatieAdapter;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.fragment.HeaderFragment;
import com.example.melanie.appaens.model.Categorie;
import com.example.melanie.appaens.model.Informatie;

import java.util.List;

public class ScrollMenuActivity extends AppCompatActivity {

    private List<Categorie> mCategorieList;
    private List<Informatie> mInformatieList;
    private int[] mDrawableList;
    private int[] mColorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_menu);
        getSupportActionBar().hide();

        DataSource data = new DataSource();
        mCategorieList = data.getCategories();
        mDrawableList = data.getDrawables();
        mInformatieList = data.getInformatieList();
        mColorList = data.getColors();

        AppCompatActivity activity = (AppCompatActivity) this;
        HeaderFragment myFragment = new HeaderFragment();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.header_fragment, myFragment).addToBackStack(null).commit();

        initRecyclerviewNavigation();
        initRecyclerviewInformatie();
    }

    private void initRecyclerviewNavigation(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView rv = (RecyclerView) findViewById(R.id.idMenu_NavigationList);
        rv.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mCategorieList, mDrawableList);
        rv.setAdapter(adapter);
    }

    private void initRecyclerviewInformatie(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView rv = (RecyclerView) findViewById(R.id.idMenu_InformationList);
        rv.setLayoutManager(layoutManager);
        RecyclerViewInformatieAdapter adapter = new RecyclerViewInformatieAdapter(this, mInformatieList, mColorList);
        rv.setAdapter(adapter);
    }

    //transition overrides
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_right, R.anim.right_left);
    }
}
