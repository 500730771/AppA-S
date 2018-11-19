package com.example.melanie.appaens.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.melanie.appaens.R;
import com.example.melanie.appaens.model.Categorie;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private Context context;
    private List<Categorie> mCategorie;
    private int[] mDrawableList;

    public RecyclerViewAdapter(Context context, List<Categorie> mCategorie, int[] mDrawableList){
        this.context = context;
        this.mCategorie = mCategorie;
        this.mDrawableList = mDrawableList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tob_menu_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
         holder.item_title.setText(mCategorie.get(position).getBeantwoordeVragen() + "/" + mCategorie.get(position).getMaxVragen());
         holder.item_image.setImageResource(mDrawableList[mCategorie.get(position).getImage()]);

//         holder.header_title.setText(mCategorie.get(position).getNaam());
//         holder.header_image.setImageResource(mDrawableList[mCategorie.get(position).getImage()]);

         holder.item_box.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                 Toast.makeText(context, mCategorie.get(position).getNaam(),Toast.LENGTH_SHORT).show();

//                 holder.header_title.setText(mCategorie.get(position).getNaam());
//                 holder.header_image.setImageResource(mDrawableList[mCategorie.get(position).getImage()]);
             }
         });
    }

    @Override
    public int getItemCount() {
        return mCategorie.size();
    }

    public onItemClickListener listener;

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }

    public interface onItemClickListener{
        void onItemClick(View view, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_title;
        ImageView item_image;
        LinearLayout item_box;

        TextView header_title;
        ImageView header_image;

        public ViewHolder(View itemView){
            super(itemView);
            item_title = (TextView) itemView.findViewById(R.id.idTopMenu_text);
            item_image = (ImageView) itemView.findViewById(R.id.idTopMenu_image);
            item_box = (LinearLayout) itemView.findViewById(R.id.idTopMenuBox);

            header_title = (TextView) itemView.findViewById(R.id.idMenu_HeaderTitle);
            header_image = (ImageView) itemView.findViewById(R.id.idMenu_HeaderImage);
        }
    }
}
