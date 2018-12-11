package com.example.melanie.appaens.fragment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.activity.AdviesActivity;
import com.example.melanie.appaens.activity.MainActivity;
import com.example.melanie.appaens.activity.StartActivity;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Question;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

    private Context context;
    private List<Question> questionList;

    private Button mButtonVerder;

    private TextView mAantalRood;
    private TextView mAantalOranje;
    private TextView mAantalGeel;
    private TextView mAantalBlauw;
    private TextView mAantalGroen;
    private TextView mAantalRoze;
    private TextView mAantalPaars;

    public OverviewFragment(){

    }

    public OverviewFragment(Context context) {
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_overview, container, false);
        view.setTag("OVERVIEWFRAGMENT");

        DataSource data = new DataSource();
        questionList = data.getQuestionList();

        mButtonVerder = (Button) view.findViewById(R.id.idOverview_verder);

        mButtonVerder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(context)
                        .setMessage("Weet u zeker dat u de checklist wilt afronden?")
                        .setCancelable(false)
                        .setPositiveButton("Ja", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(context, AdviesActivity.class));
                            }
                        })
                        .setNegativeButton("Nee", null)
                        .show();

            }
        });

        mAantalRood = (TextView) view.findViewById(R.id.idOverview_aantalRood);
        mAantalOranje = (TextView) view.findViewById(R.id.idOverview_aantalOranje);
        mAantalGeel = (TextView) view.findViewById(R.id.idOverview_aantalGeel);
        mAantalBlauw = (TextView) view.findViewById(R.id.idOverview_aantalBlauw);
        mAantalGroen = (TextView) view.findViewById(R.id.idOverview_aantalGroen);
        mAantalRoze = (TextView) view.findViewById(R.id.idOverview_aantalRoze);
        mAantalPaars = (TextView) view.findViewById(R.id.idOverview_aantalPaars);

        mAantalRood.setText("" + data.getScoreButton(1));
        mAantalOranje.setText("" + data.getScoreButton(2));
        mAantalGeel.setText("" + data.getScoreButton(3));
        mAantalBlauw.setText("" + data.getScoreButton(4));
        mAantalGroen.setText("" + data.getScoreButton(5));
        mAantalRoze.setText("" + data.getScoreButton(6));
        mAantalPaars.setText("" + data.getScoreButton(7));

        return view;
    }
}
