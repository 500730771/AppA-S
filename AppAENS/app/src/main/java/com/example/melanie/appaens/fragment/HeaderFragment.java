package com.example.melanie.appaens.fragment;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.activity.ScrollMenuActivity;
import com.example.melanie.appaens.adapter.RecyclerViewAdapter;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Categorie;

public class HeaderFragment extends Fragment {

    private static final String TAG = "HEADERFRAGMENT";
    private View rootView;

    private static Categorie mCategorie;
    private static int[] mDrawableList;

    public HeaderFragment()
    {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.fragment_header, container, false);
        rootView.setTag(TAG);

        DataSource data = new DataSource();
        mDrawableList = data.getDrawables();
        RecyclerViewAdapter adapter = new RecyclerViewAdapter();
        if (adapter.getCurrentCategorie() != null){
            mCategorie = adapter.getCurrentCategorie();

            Log.d(TAG, "SET HEADER TO CATEGORIE "+ mCategorie.getImage());
        } else {
            mCategorie = data.getCategories().get(0);
            Log.d(TAG, "SET HEADER TO CATEGORIE 0");
        }

        setText(rootView, mCategorie);

        return rootView;
    }

    public void setText(View view, Categorie categorie){
        TextView header_text = (TextView) view.findViewById(R.id.idFragment_text);
        ImageView header_image = (ImageView) view.findViewById(R.id.idFragment_image);

        header_text.setText(categorie.getNaam());
        header_image.setImageResource(mDrawableList[categorie.getImage()]);
    }
}
