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
import com.example.asus.graduationproject.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder> {
    private Context context;
    private List<DailyItem> list;
    DailyAdapter(Context context, List<DailyItem> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_item,parent,false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView name;
        TextView content;
        ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            content=itemView.findViewById(R.id.content);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               switch (position){
                   case 0:
                       Intent intent=new Intent(context,StepCountActivity.class);
                       context.startActivity(intent);
                       break;
                   case 1:
                       Intent intent2=new Intent(context,RecordActivity.class);
                       context.startActivity(intent2);
                       break;
                   case 2:
                       Intent intent3=new Intent(context,SurveyActivity.class);
                       context.startActivity(intent3);
                       break;
                   case 3:
                       Intent intent4=new Intent(context,ArticleActivity.class);
                       context.startActivity(intent4);
                   default:
                       Toast.makeText(context,"待后续开发……",Toast.LENGTH_SHORT).show();
                       break;
               }
            }
        });
        holder.imageView.setImageResource(list.get(position).getImage());
        holder.name.setText(list.get(position).getName());
        holder.content.setText(list.get(position).getContent());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
