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
import com.example.melanie.appaens.model.Informatie;
import com.example.melanie.appaens.model.Question;

import java.util.List;

public class RecyclerViewQuestionAdapter extends RecyclerView.Adapter<RecyclerViewQuestionAdapter.ViewHolderInformatie>{

    private Context context;
    private List<Question> mQuestionList;
    private int[] colorList;
    private Button[] buttonList;

    public RecyclerViewQuestionAdapter(Context context, List<Question> mQuestionList){
        this.context = context;
        this.mQuestionList = mQuestionList;
        DataSource data = new DataSource();
        colorList = data.getColors();
    }

    @NonNull
    @Override
    public RecyclerViewQuestionAdapter.ViewHolderInformatie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.display_question, parent, false);
        return new RecyclerViewQuestionAdapter.ViewHolderInformatie(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewQuestionAdapter.ViewHolderInformatie holder, final int position) {
        holder.mQuestion.setText(mQuestionList.get(position).getQuestion());
        buttonList = new Button[7];
        buttonList[0] = holder.mButtonRed;
        buttonList[1] = holder.mButtonOrange;
        buttonList[2] = holder.mButtonYellow;
        buttonList[3] = holder.mButtonBlue;
        buttonList[4] = holder.mButtonGreen;
        buttonList[5] = holder.mButtonPink;
        buttonList[6] = holder.mButtonPurple;

        int i = 0;
        for (Button b : buttonList) {
            if (mQuestionList.get(position).getAnswerClient() == 0) {
                setButton(b, i, 0, mQuestionList.get(position));
            } else {
                setButtonBorder(b, i, mQuestionList.get(position).getAnswerClient(), mQuestionList.get(position));
            }
            i++;
        }

        holder.mButtonRed.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonRed, 0, 1, mQuestionList.get(position));
            }
        });
        holder.mButtonOrange.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonOrange, 1, 2, mQuestionList.get(position));
            }
        });
        holder.mButtonYellow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonYellow, 2, 3, mQuestionList.get(position));
            }
        });
        holder.mButtonBlue.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonBlue, 3, 4, mQuestionList.get(position));
            }
        });
        holder.mButtonGreen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonGreen, 4, 5, mQuestionList.get(position));
            }
        });
        holder.mButtonPink.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonPink, 5, 6, mQuestionList.get(position));
            }
        });
        holder.mButtonPurple.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                buttonClick(holder.mButtonPurple, 6, 7, mQuestionList.get(position));
            }
        });
    }

    private void buttonClick(Button button, int color, int answer, Question question){
        if (question.getAnswerClient() != 0){
            switch (question.getAnswerClient()){
                case 1: setButton(buttonList[0], 0, 0, question);
                    break;
                case 2: setButton(buttonList[1], 1, 0, question);
                    break;
                case 3: setButton(buttonList[2], 2, 0, question);
                    break;
                case 4: setButton(buttonList[3], 3, 0, question);
                    break;
                case 5: setButton(buttonList[4], 4, 0, question);
                    break;
                case 6: setButton(buttonList[5], 5, 0, question);
                    break;
                case 7: setButton(buttonList[6], 6, 0, question);
                    break;
            }
        }
        question.setAnswerClient(answer);
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
