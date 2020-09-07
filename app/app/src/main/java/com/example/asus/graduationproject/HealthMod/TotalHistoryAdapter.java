package com.example.asus.graduationproject.HealthMod;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.graduationproject.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.Context.MODE_PRIVATE;

public class TotalHistoryAdapter extends RecyclerView.Adapter<TotalHistoryAdapter.ViewHolder> {

    private Context context;
    private List<String> list;
    private String user_name;
    //List<>
    TotalHistoryAdapter(Context context, List<String> list) {
        user_name=context.getSharedPreferences("login",MODE_PRIVATE).getString("account","");
        this.context=context;
        this.list=list;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView user_name;
        TextView date;
        ViewHolder(@NonNull View itemView) {
            super(itemView);

            user_name=itemView.findViewById(R.id.user_name);
            date=itemView.findViewById(R.id.date);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.total_history_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //查看该用户该天体检记录的细则
                Intent intent=new Intent(context,TotalHistoryDataActivity.class);
                intent.putExtra("date",list.get(position));
                intent.putExtra("user_name",user_name);
                context.startActivity(intent);
            }
        });
        holder.date.setText(list.get(position));
        holder.user_name.setText(user_name);
    }



    @Override
    public int getItemCount() {
        return list.size();
    }
}
