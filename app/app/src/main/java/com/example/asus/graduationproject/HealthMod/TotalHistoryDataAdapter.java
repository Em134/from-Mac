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

public class TotalHistoryDataAdapter extends RecyclerView.Adapter<TotalHistoryDataAdapter.ViewHolder> {
    private Context context;
    private List<ExamData> list;
    //List<>
    TotalHistoryDataAdapter(Context context, List<ExamData> list) {
        this.context=context;
        this.list=list;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView category;
        TextView item_name;
        TextView value;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            category=itemView.findViewById(R.id.category);
            item_name=itemView.findViewById(R.id.item_name);
            value=itemView.findViewById(R.id.value);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.total_history_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.value.setText(list.get(position).getVal());
        holder.item_name.setText(list.get(position).getItem_name());
        holder.category.setText(list.get(position).getCategory());
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
