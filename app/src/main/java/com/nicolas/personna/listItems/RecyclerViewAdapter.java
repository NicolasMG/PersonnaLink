package com.nicolas.personna.listItems;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nicolas.personna.R;
import com.nicolas.personna.db.PersonnaModel;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private List<PersonnaModel> personnaModelList;
    private View.OnLongClickListener longClickListener;
    private View.OnClickListener clickListener;

    public List<PersonnaModel> getPersonnaModelList(){
        return personnaModelList;
    }

    public RecyclerViewAdapter(List<PersonnaModel> personnaModelList, View.OnLongClickListener longClickListener, View.OnClickListener clickListener) {
        this.personnaModelList = personnaModelList;
        this.longClickListener = longClickListener;
        this.clickListener = clickListener;
    }


        @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolder holder, int position) {
        PersonnaModel personnaModel = personnaModelList.get(position);
        String sexe = personnaModel.getSexe();
        int color = 0;
        switch (sexe){
            case "Homme":
                color = Color.rgb(155, 226, 248);
                break;
            case "Femme":
                color = Color.rgb(249, 97, 211);
                break;
            default :
                color = Color.rgb(155, 226, 248);
                break;
        }

        holder.itemTextView.setText(personnaModel.getItemName());
        holder.itemTextView.setTextColor(color);
        holder.nameTextView.setText(personnaModel.getPersonName());
        holder.nameTextView.setTextColor(color);
        holder.dateTextView.setText(personnaModel.getPersonnaDate().toLocaleString().substring(0, 11));
        holder.itemView.setTag(personnaModel);
        holder.itemView.setOnLongClickListener(longClickListener);
        holder.itemView.setOnClickListener(clickListener);

    }

    @Override
    public int getItemCount() {
        return personnaModelList.size();
    }

    public void addItems(List<PersonnaModel> personnaModelList) {
        this.personnaModelList = personnaModelList;
        notifyDataSetChanged();
    }

    static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTextView;
        private TextView nameTextView;
        private TextView dateTextView;

        RecyclerViewHolder(View view) {
            super(view);
            itemTextView = view.findViewById(R.id.itemTextView);
            nameTextView = view.findViewById(R.id.nameTextView);
            dateTextView = view.findViewById(R.id.dateTextView);
        }
    }
}