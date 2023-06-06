package com.example.recyclerviewex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {
    Context context;
    ArrayList<ContactModel> arrContact;
    RecyclerContactAdapter(Context context, ArrayList<ContactModel> arrContact){
        this.context = context;
        this.arrContact = arrContact;

    }

   @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
     ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ContactModel contactModel = arrContact.get(position);
        holder.contImg.setImageBitmap(arrContact.get(position).img);
        holder.contName.setText(arrContact.get(position).contName);
        holder.contNum.setText(arrContact.get(position).contNum);

    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView contName , contNum;
        ImageView contImg;

        public ViewHolder(View itemView) {
            super(itemView);
            contName = itemView.findViewById(R.id.cont_name);
            contImg = itemView.findViewById(R.id.Cont_img);
            contNum = itemView.findViewById(R.id.Cont_num);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    // Delete the contact when long-pressed
                    arrContact.remove(getAdapterPosition());
                    notifyDataSetChanged();
                    return true;
                }
            });
        }
    }
}
