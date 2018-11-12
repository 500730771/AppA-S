package com.example.melanie.appaens.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.melanie.appaens.model.Categorie;

import java.util.List;

public class MenuItemAdapter extends BaseAdapter {

    private Context context;
    private List<Categorie> mCategorie;

    public MenuItemAdapter(Context context, List<Categorie> mCategorie) {
        this.context = context;
        this.mCategorie = mCategorie;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mCategorie.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        return convertView;
    }
}
