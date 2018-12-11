package com.example.melanie.appaens.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.adapter.RecyclerViewAdapter;
import com.example.melanie.appaens.adapter.RecyclerViewInformatieAdapter;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.fragment.HeaderFragment;
import com.example.melanie.appaens.fragment.QuestionFragment;
import com.example.melanie.appaens.model.Categorie;
import com.example.melanie.appaens.model.Informatie;
import com.example.melanie.appaens.model.Question;

import java.util.List;

public class ScrollMenuActivity extends AppCompatActivity {

    private List<Categorie> mCategorieList;
    private List<Informatie> mInformatieList;
    private List<Question> mQuestionList;
    private int[] mDrawableList;
    private int[] mColorList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_menu);
        getSupportActionBar().hide();

        DataSource data = new DataSource();
        mCategorieList = data.getCategories();
        mDrawableList = data.getDrawablesCategorie();
        mInformatieList = data.getInformatieList();
        mColorList = data.getColors();
        mQuestionList = data.getQuestionListCategorie(0);

        AppCompatActivity activity = (AppCompatActivity) this;
        HeaderFragment myFragment = new HeaderFragment();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.header_fragment, myFragment).addToBackStack(null).commit();

        QuestionFragment qfragment = new QuestionFragment(this, 0);
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.question_fragment, qfragment).addToBackStack(null).commit();

        initRecyclerviewNavigation();
        initRecyclerviewInformatie();
    }

    public void initRecyclerviewNavigation(){
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
        Intent intent = new Intent(this , StartActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(intent);
        overridePendingTransition(R.anim.left_right, R.anim.right_left);
    }
}
