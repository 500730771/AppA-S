package com.example.melanie.appaens.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.adapter.RecyclerViewQuestionAdapter;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Question;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    private Context context;
    private int idCategorie;
    private View rootView;
    private String TAG = "QUESTIONFRAGMENT";

    public QuestionFragment() {
        // Required empty public constructor
    }

    public QuestionFragment(Context context, int idCategorie){
        this.context = context;
        this.idCategorie = idCategorie;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_question, container, false);
        rootView.setTag(TAG);

        DataSource data = new DataSource();
        List<Question> questionList = data.getQuestionListCategorie(idCategorie);

        initRecyclerviewQuestion(rootView, questionList);

        return rootView;
    }

    private void initRecyclerviewQuestion(View view, List<Question> mQuestionList){
        LinearLayoutManager layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.idFragment_questionlist);
        rv.setLayoutManager(layoutManager);
        RecyclerViewQuestionAdapter adapter = new RecyclerViewQuestionAdapter(context, mQuestionList);
        rv.setAdapter(adapter);
    }
}
