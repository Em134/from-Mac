package com.example.asus.graduationproject.HealthMod;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.graduationproject.JavaBean.ExamData;
import com.example.asus.graduationproject.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context context;
    private List<ExamData> list;
    private String name;

    //List<>
    HistoryAdapter(Context context, List<ExamData> list,String name) {
        this.context=context;
        this.list=list;
        this.name=name;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView item_name;
        TextView date;
        TextView value;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name=itemView.findViewById(R.id.item_name);
            date=itemView.findViewById(R.id.date);
            value=itemView.findViewById(R.id.value);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.item_name.setText(name);
        holder.date.setText(list.get(position).getDate());
        holder.value.setText(list.get(position).getVal());
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
