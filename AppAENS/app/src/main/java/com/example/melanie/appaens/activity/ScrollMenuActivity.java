package com.example.melanie.appaens.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.adapter.MenuItemAdapter;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Categorie;

import java.util.List;

public class ScrollMenuActivity extends AppCompatActivity {

    private ListView menuList;

    private List<Categorie> mCategorieList;
    private int[] mDrawableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_menu);

        DataSource data = new DataSource();
        mCategorieList = data.getCategories();
        mDrawableList = data.getDrawables();

        menuList = (ListView) findViewById(R.id.idMenu_list);

        // set adapter
        final MenuItemAdapter adapter = new MenuItemAdapter(this, mCategorieList, mDrawableList);
        menuList.setAdapter(adapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(Dida.this, TabActivity.class);
//                DialogueCard selectedCard = adapter.getItem(position);
//                intent.putExtra("selectedCard", selectedCard);
//                Dida.this.startActivity(intent);
//                overridePendingTransition(R.anim.enter, R.anim.exit);
            }
        });

    }
}
