package com.example.melanie.appaens.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Question;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OverviewFragment extends Fragment {

    private Context context;
    private List<Question> questionList;

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

        mAantalRood = (TextView) view.findViewById(R.id.idOverview_aantalRood);
        mAantalOranje = (TextView) view.findViewById(R.id.idOverview_aantalOranje);
        mAantalGeel = (TextView) view.findViewById(R.id.idOverview_aantalGeel);
        mAantalBlauw = (TextView) view.findViewById(R.id.idOverview_aantalBlauw);
        mAantalGroen = (TextView) view.findViewById(R.id.idOverview_aantalGroen);
        mAantalRoze = (TextView) view.findViewById(R.id.idOverview_aantalRoze);
        mAantalPaars = (TextView) view.findViewById(R.id.idOverview_aantalPaars);
        
        mAantalRood.setText("" + getAantal(1));
        mAantalOranje.setText("" + getAantal(2));
        mAantalGeel.setText("" + getAantal(3));
        mAantalBlauw.setText("" + getAantal(4));
        mAantalGroen.setText("" + getAantal(5));
        mAantalRoze.setText("" + getAantal(6));
        mAantalPaars.setText("" + getAantal(7));

        return view;
    }

    private int getAantal(int kleurid){
        int aantal = 0;

        for (Question q : questionList){
            if (q.getAnswerClient() == kleurid){
                aantal++;
            }
        }

        return aantal;
    }
}
