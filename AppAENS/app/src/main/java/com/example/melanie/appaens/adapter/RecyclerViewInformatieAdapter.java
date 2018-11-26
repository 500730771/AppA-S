package com.example.melanie.appaens.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
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
import com.example.melanie.appaens.model.Informatie;

import java.util.List;

public class RecyclerViewInformatieAdapter extends RecyclerView.Adapter<RecyclerViewInformatieAdapter.ViewHolderInformatie>{

    private Context context;
    private List<Informatie> mInformatieList;
    private int[] mColorList;

    public RecyclerViewInformatieAdapter(Context context, List<Informatie> mInformatieList, int[] mColorList){
        this.context = context;
        this.mInformatieList = mInformatieList;
        this.mColorList = mColorList;
    }

    @NonNull
    @Override
    public RecyclerViewInformatieAdapter.ViewHolderInformatie onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gespannen_item, parent, false);
        return new RecyclerViewInformatieAdapter.ViewHolderInformatie(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewInformatieAdapter.ViewHolderInformatie holder, final int position) {
        holder.text.setText(mInformatieList.get(position).getShortText());
        holder.color.setBackgroundColor(ContextCompat.getColor(context, this.mColorList[mInformatieList.get(position).getKleur()]));

        holder.box.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mInformatieList.get(position).getShortText(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mInformatieList.size();
    }

    public class ViewHolderInformatie extends RecyclerView.ViewHolder {

        TextView text;
        View color;
        LinearLayout box;

        public ViewHolderInformatie(View itemView){
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.idInformatie_text);
            color = (View) itemView.findViewById(R.id.idInformatie_color);
            box = (LinearLayout) itemView.findViewById(R.id.idInformatie_box);
        }
    }
}
