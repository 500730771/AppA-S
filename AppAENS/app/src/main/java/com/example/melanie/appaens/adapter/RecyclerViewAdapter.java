package com.example.melanie.appaens.adapter;

import android.content.Context;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.data.DataSource;
import com.example.melanie.appaens.fragment.HeaderFragment;
import com.example.melanie.appaens.fragment.OverviewFragment;
import com.example.melanie.appaens.fragment.QuestionFragment;
import com.example.melanie.appaens.model.Categorie;
import com.example.melanie.appaens.model.Question;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context context;
    private static Categorie current;
    private static List<Categorie> mCategorie;
    private static int[] mDrawableList;

    private View view;

    public RecyclerViewAdapter(){

    }

    public RecyclerViewAdapter(Context context, List<Categorie> mCategorie, int[] mDrawableList){
        this.context = context;
        this.mCategorie = mCategorie;
        this.mDrawableList = mDrawableList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tob_menu_item, parent, false);
        return new ViewHolder(view);
    }

    private int getBeantwoordeVragen(int categorieId){
        DataSource data = new DataSource();
        List<Question> list = data.getQuestionListCategorie(categorieId);
        int aantal = 0;
        for (Question q : list){
            if (q.getAnswerClient() !=0)
                aantal++;
        }
        return aantal;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        if(mCategorie.size() -1  == position){
            holder.item_title.setText("Klaar");

        }else {
            holder.item_title.setText(getBeantwoordeVragen(mCategorie.get(position).getId()) + "/" + mCategorie.get(position).getMaxVragen());
        }
        holder.item_image.setImageResource(mDrawableList[position]);

         holder.item_box.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 current = mCategorie.get(position);

                 //header
                 AppCompatActivity activity = (AppCompatActivity) view.getContext();
                 HeaderFragment myFragment = new HeaderFragment();
                 activity.getSupportFragmentManager().beginTransaction().replace(R.id.header_fragment, myFragment).addToBackStack(null).commit();

                 //klaar button leads to overview page
                 //otherwise to question list page

                 Log.d("RECYCLEVIEWADAPTER", "ID: " + current.getId());
                 if (current.getId() == mCategorie.size() -1){
                     OverviewFragment oFragment = new OverviewFragment(context);
                     activity.getSupportFragmentManager().beginTransaction().replace(R.id.question_fragment, oFragment).addToBackStack(null).commit();
                 } else {
                     //question list
                     QuestionFragment qFragment = new QuestionFragment(context, current.getId());
                     activity.getSupportFragmentManager().beginTransaction().replace(R.id.question_fragment, qFragment).addToBackStack(null).commit();
                 }
             }
         });
    }

    public Categorie getCurrentCategorie(){
        return current;
    }

    public void setCurrent(Categorie nieuw){ current = nieuw;}

    public int[] getmDrawableList(){
        return mDrawableList;
    }

    @Override
    public int getItemCount() {
        return mCategorie.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_title;
        ImageView item_image;
        LinearLayout item_box;

        public ViewHolder(View itemView){
            super(itemView);
            item_title = (TextView) itemView.findViewById(R.id.idTopMenu_text);
            item_image = (ImageView) itemView.findViewById(R.id.idTopMenu_image);
            item_box = (LinearLayout) itemView.findViewById(R.id.idTopMenuBox);
        }
    }
}
