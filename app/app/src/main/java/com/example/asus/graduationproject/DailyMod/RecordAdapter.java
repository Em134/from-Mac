package com.example.asus.graduationproject.DailyMod;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.graduationproject.JavaBean.DailyItem;
import com.example.asus.graduationproject.JavaBean.SportData;
import com.example.asus.graduationproject.R;

import org.w3c.dom.Text;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.ViewHolder> {
    private Context context;
    private List<SportData> list;
    RecordAdapter(Context context, List<SportData> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sport_record,parent,false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView type;
        TextView sportTime;
        TextView startTime;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            type=itemView.findViewById(R.id.type);
            sportTime=itemView.findViewById(R.id.sportTime);
            startTime=itemView.findViewById(R.id.startTime);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.type.setText(list.get(position).getType());
        holder.startTime.setText(list.get(position).getSportDate()+"   "+list.get(position).getStartTime());
        holder.sportTime.setText(list.get(position).getSportTime());
        switch (list.get(position).getType()){
            case "户外跑步":
                holder.imageView.setImageResource(R.drawable.run);
                break;
            case "户外骑行":
                holder.imageView.setImageResource(R.drawable.ride);
                break;
            case "泳池游泳":
                holder.imageView.setImageResource(R.drawable.swim);
                break;
            case "打篮球":
                holder.imageView.setImageResource(R.drawable.basketball);
                break;
            default:break;
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
