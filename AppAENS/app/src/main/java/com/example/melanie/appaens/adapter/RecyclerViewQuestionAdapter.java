package com.example.melanie.appaens.adapter;

import android.content.Context;
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
import com.example.melanie.appaens.model.Informatie;
import com.example.melanie.appaens.model.Question;

import java.util.List;

public class RecyclerViewQuestionAdapter extends RecyclerView.Adapter<RecyclerViewQuestionAdapter.ViewHolderInformatie>{

    private Context context;
    private List<Question> mQuestionList;

    public RecyclerViewQuestionAdapter(Context context, List<Question> mQuestionList){
        this.context = context;
        this.mQuestionList = mQuestionList;
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
