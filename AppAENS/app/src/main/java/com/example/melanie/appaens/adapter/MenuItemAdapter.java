package com.example.melanie.appaens.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.model.Categorie;

import java.util.List;

public class MenuItemAdapter {

    private Context context;
    private Categorie mCategorie;
    private int plaatje;
    private int[] mDrawableList;

    public MenuItemAdapter(Context context, Categorie mCategorie, int plaatje, int[] mDrawableList) {
        this.context = context;
        this.mCategorie = mCategorie;
        this.plaatje = plaatje;
        this.mDrawableList = mDrawableList;
    }

    public void initTitle(TextView text, ImageView image){
        text.setText(mCategorie.getNaam());
        image.setImageResource(mDrawableList[plaatje]);
    }
}
