package com.example.uireplication.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uireplication.R;

public class ListAdapter1 extends RecyclerView.Adapter<ListAdapter1.MyViewHolder> {

    Context context;

    public ListAdapter1(Context context) {

        this.context = context;


    }
    int a=2;
    @NonNull
    @Override
    public ListAdapter1.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler,parent,false);





        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter1.MyViewHolder holder, int position) {

        holder.textView.setText(""+ a++ +":30");
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textt);
        }
    }
}
