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

public class MenuItemAdapter extends BaseAdapter {

    private Context context;
    private List<Categorie> mCategorie;
    private int[] mDrawableList;

    public MenuItemAdapter(Context context, List<Categorie> mCategorie, int[] mDrawableList) {
        this.context = context;
        this.mCategorie = mCategorie;
        this.mDrawableList = mDrawableList;
        Log.d("ADAPTER", "Adapter constructor ");
    }

    @Override
    public int getCount() {
        return mCategorie.size();
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d("ADAPTER", "view ");

        view = inflater.inflate(R.layout.tob_menu_item, viewGroup, false);
        TextView item_title = (TextView) view.findViewById(R.id.idTopMenu_text);
        item_title.setText((mCategorie.get(position)).getNaam());

        ImageView item_image = (ImageView) view.findViewById(R.id.idTopMenu_image);
        item_image.setImageResource(mDrawableList[mCategorie.get(position).getImage()]);
//        view.setOnClickListener(null);

        return view;
    }
}
