package com.example.jm.jimmy_1202150108_modul5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


/**
 * Created by JM on 3/24/2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.holder> {
    private Context mcon;
    private List<TambahData> list;
    int warna;


    class holder extends RecyclerView.ViewHolder{
        public TextView todo, desk, prioritas;
        public CardView list;
        public holder(View itemView){
            super(itemView);

            //get id text view dan cardview pada layout
            todo = itemView.findViewById(R.id.todo);
            desk = itemView.findViewById(R.id.deskripsi1);
            prioritas = itemView.findViewById(R.id.angka);
            list = itemView.findViewById(R.id.list);
        }
    }


    public Adapter(Context conteks, List<TambahData> list, int warna){
        this.mcon=conteks;
        this.list=list;
        this.warna=warna;
    }

    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcon).inflate(R.layout.list, parent, false);
        holder holdr = new holder(view);
        return holdr;
    }
    @Override
    public void onBindViewHolder(holder holder, int position) {
        TambahData data = list.get(position);
        holder.todo.setText(data.getTodo());
        holder.desk.setText(data.getDesc());
        holder.prioritas.setText(data.getPrior());
        holder.list.setCardBackgroundColor(mcon.getResources().getColor(this.warna));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public TambahData getData(int position){
        return list.get(position);
    }

    public void deleteData(int i){
        list.remove(i);
        notifyItemRemoved(i);
        notifyItemRangeChanged(i, list.size());
    }

}
