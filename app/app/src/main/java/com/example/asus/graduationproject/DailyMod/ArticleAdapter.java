package com.example.asus.graduationproject.DailyMod;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.graduationproject.JavaBean.DailyItem;
import com.example.asus.graduationproject.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    private Context context;
    private List<DailyItem> list;
    ArticleAdapter(Context context, List<DailyItem> list){
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item,parent,false);
        return new ViewHolder(view);
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout container;
        TextView name;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            container=itemView.findViewById(R.id.container);
            name=itemView.findViewById(R.id.name);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                       Toast.makeText(context,"展示文件",Toast.LENGTH_SHORT).show();


            }
        });
        holder.container.setBackgroundResource((list.get(position).getImage()));
        holder.name.setText(list.get(position).getName());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
