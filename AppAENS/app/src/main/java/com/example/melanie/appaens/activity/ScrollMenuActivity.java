package com.example.melanie.appaens.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.adapter.RecyclerViewAdapter;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Categorie;

import java.util.List;

public class ScrollMenuActivity extends AppCompatActivity {

    private List<Categorie> mCategorieList;
    private int[] mDrawableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_menu);
        getSupportActionBar().hide();

        DataSource data = new DataSource();
        mCategorieList = data.getCategories();
        mDrawableList = data.getDrawables();

        initRecyclerView();
    }

    private void initRecyclerView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView rv = (RecyclerView) findViewById(R.id.idMenu_NavigationList);
        rv.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mCategorieList, mDrawableList);
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener(new RecyclerViewAdapter.onItemClickListener(){
            @Override
            public void onItemClick(View view, int position){
                TextView header_title = (TextView) view.findViewById(R.id.idMenu_HeaderTitle);
                ImageView header_image = (ImageView) view.findViewById(R.id.idMenu_HeaderImage);

                header_title.setText(mCategorieList.get(position).getNaam());
                header_image.setImageResource(mDrawableList[mCategorieList.get(position).getImage()]);
            }
        });
    }

    //transition overrides
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.left_right, R.anim.right_left);
    }
}
