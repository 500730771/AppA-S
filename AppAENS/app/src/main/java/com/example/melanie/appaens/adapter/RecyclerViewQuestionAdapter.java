package com.example.melanie.appaens.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.activity.Popup;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.model.Categorie;
import com.example.melanie.appaens.model.Informatie;
import com.example.melanie.appaens.model.Question;

import java.util.List;

public class RecyclerViewQuestionAdapter extends RecyclerView.Adapter<RecyclerViewQuestionAdapter.ViewHolderInformatie>{

    private Context context;
    private static List<Question> mQuestionList;
    private static List<Categorie> mCategorieList;
    private static int[] colorList;
    private static Button[][] buttonList;
    private static DataSource data;

    public RecyclerViewQuestionAdapter(Context context, List<Question> mQuestionList){
        this.context = context;
        data = new DataSource();
        this.mQuestionList = mQuestionList;
        colorList = data.getColors();
        mCategorieList = data.getCategories();
        buttonList = new Button[mQuestionList.size()][7];
    }

    @NonNull
    @Override
    public RecyclerViewQuestionAdapter.ViewHolderInformatie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_question, parent, false);
        return new RecyclerViewQuestionAdapter.ViewHolderInformatie(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewQuestionAdapter.ViewHolderInformatie holder, final int position) {
        // set question text
        holder.mQuestion.setText(mQuestionList.get(position).getQuestion());
        print();

        // save all buttons in a list
        buttonList[position][0] = holder.mButtonRed;
        buttonList[position][1] = holder.mButtonOrange;
        buttonList[position][2] = holder.mButtonYellow;
        buttonList[position][3] = holder.mButtonBlue;
        buttonList[position][4] = holder.mButtonGreen;
        buttonList[position][5] = holder.mButtonPink;
        buttonList[position][6] = holder.mButtonPurple;

        // set all the buttons
        for (int i = 0; i < 7; i++) {
            setButton(buttonList[position][i], i, 0, mQuestionList.get(position));

            // if answer is already set, then add border
            switch (mQuestionList.get(position).getAnswerClient()){
                case 0: setButton(buttonList[position][i], i, 0, mQuestionList.get(position));
                    break;
                case 1: setButtonBorder(buttonList[position][0], 0, 0, mQuestionList.get(position));
                    break;
                case 2: setButtonBorder(buttonList[position][1], 1, 0, mQuestionList.get(position));
                    break;
                case 3: setButtonBorder(buttonList[position][2], 2, 0, mQuestionList.get(position));
                    break;
                case 4: setButtonBorder(buttonList[position][3], 3, 0, mQuestionList.get(position));
                    break;
                case 5: setButtonBorder(buttonList[position][4], 4, 0, mQuestionList.get(position));
                    break;
                case 6: setButtonBorder(buttonList[position][5], 5, 0, mQuestionList.get(position));
                    break;
                case 7: setButtonBorder(buttonList[position][6], 6, 0, mQuestionList.get(position));
                    break;
            }
        }

        holder.mButtonRed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonRed, 0, 1, mQuestionList.get(position), position);
            }
        });
        holder.mButtonOrange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonOrange, 1, 2, mQuestionList.get(position), position);
            }
        });
        holder.mButtonYellow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonYellow, 2, 3, mQuestionList.get(position), position);
            }
        });
        holder.mButtonBlue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonBlue, 3, 4, mQuestionList.get(position), position);
            }
        });
        holder.mButtonGreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonGreen, 4, 5, mQuestionList.get(position), position);
            }
        });
        holder.mButtonPink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonPink, 5, 6, mQuestionList.get(position), position);
            }
        });
        holder.mButtonPurple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonPurple, 6, 7, mQuestionList.get(position), position);
            }
        });
    }

    private void print(){
        for (Question q:mQuestionList) {
            Log.d("ADAPTER", "Question: " + q.getQuestion()+ ", " + q.getAnswerClient() + ", " + q.getCategorieId());
        }
    }

    private void buttonClick(Button button, int color, int answer, Question question, int position){
        Log.d("ADAPTER", "Attribuut: " + position + ", " + answer);
        int extraanswer = question.getAnswerClient();
        if (question.getAnswerClient() != 0){
            switch (question.getAnswerClient()){
                case 1: setButton(buttonList[position][0], 0, 0, question);
                    break;
                case 2: setButton(buttonList[position][1], 1, 0, question);
                    break;
                case 3: setButton(buttonList[position][2], 2, 0, question);
                    break;
                case 4: setButton(buttonList[position][3], 3, 0, question);
                    break;
                case 5: setButton(buttonList[position][4], 4, 0, question);
                    break;
                case 6: setButton(buttonList[position][5], 5, 0, question);
                    break;
                case 7: setButton(buttonList[position][6], 6, 0, question);
                    break;
            }
        }
        // lijst met 1 attribuut, moet worden veranderd naar de hele lijst.
        question.setAnswerClient(answer);
        data.setQuestion(question);
        if (extraanswer == 0) {
            RecyclerViewAdapter adapter = new RecyclerViewAdapter();
            adapter.notifyItemChanged(question.getCategorieId());
        }
        setButtonBorder(button, color, answer, question);
    }

    private void setButton(Button button, int color, int answer, Question question){
        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.OVAL);
        gd.setColor(context.getResources().getColor(colorList[color]));
        button.setBackground(gd);
    }

    private void setButtonBorder(Button button, int color, int answer, Question question){
        GradientDrawable gd = new GradientDrawable();
        gd.setShape(GradientDrawable.OVAL);
        gd.setColor(context.getResources().getColor(colorList[color]));
        gd.setStroke(9, context.getResources().getColor(R.color.colorBlack));
        button.setBackground(gd);
    }

    @Override
    public int getItemCount() {
        return mQuestionList.size();
    }

    public class ViewHolderInformatie extends RecyclerView.ViewHolder {

        TextView mQuestion;

        Button mButtonRed;
        Button mButtonOrange;
        Button mButtonYellow;
        Button mButtonBlue;
        Button mButtonGreen;
        Button mButtonPink;
        Button mButtonPurple;

        EditText mToelichting;

        public ViewHolderInformatie(View itemView){
            super(itemView);

            mQuestion = (TextView) itemView.findViewById(R.id.idQuestion_question);

            mButtonRed = (Button) itemView.findViewById(R.id.idQuestion_red);
            mButtonOrange = (Button) itemView.findViewById(R.id.idQuestion_orange);
            mButtonYellow = (Button) itemView.findViewById(R.id.idQuestion_yellow);
            mButtonBlue = (Button) itemView.findViewById(R.id.idQuestion_blue);
            mButtonGreen = (Button) itemView.findViewById(R.id.idQuestion_green);
            mButtonPink = (Button) itemView.findViewById(R.id.idQuestion_pink);
            mButtonPurple = (Button) itemView.findViewById(R.id.idQuestion_purple);

            mToelichting = (EditText) itemView.findViewById(R.id.idQuestion_toelichtingtext);
        }
    }
}
