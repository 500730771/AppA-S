package com.example.melanie.appaens.activity;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Informatie;

public class Popup extends Activity {

    private View color;
    private ImageView image;

    private Informatie informatie;
    private int[] mColorList;
    private int[] mDrawableInformatieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);

        informatie = (Informatie) getIntent().getSerializableExtra("Informatie");
        DataSource data = new DataSource();
        mColorList = data.getColors();
        mDrawableInformatieList = data.getDrawablesInformatie();

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.9), (int) (height*.7));
        getWindow().setElevation(400);
        setPopup();
    }

    private void setPopup(){
        color = (View) findViewById(R.id.idPopupColor);
        image = (ImageView) findViewById(R.id.idPopupImage);

        color.setBackgroundColor(ContextCompat.getColor(this, this.mColorList[informatie.getId()]));
        image.setImageResource(mDrawableInformatieList[informatie.getId()]);
    }
}
