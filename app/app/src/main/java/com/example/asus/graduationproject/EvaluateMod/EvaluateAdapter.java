package com.example.asus.graduationproject.EvaluateMod;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.asus.graduationproject.JavaBean.ExamData;
import com.example.asus.graduationproject.JavaBean.Sickness;
import com.example.asus.graduationproject.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EvaluateAdapter extends RecyclerView.Adapter<EvaluateAdapter.ViewHolder> {
    //评估界面
    private static final String TAG="EvaluateAdapter";
    Context context;
    List<Sickness> data;
    public EvaluateAdapter(Context context, List<Sickness> data){
        this.context=context;
        this.data=data;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView category;
        TextView sickness;
        TextView item;
        TextView guidence;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            category=itemView.findViewById(R.id.category);
            sickness=itemView.findViewById(R.id.sickness);
            item=itemView.findViewById(R.id.item);
            guidence=itemView.findViewById(R.id.guidence);

        }
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.evaluate_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.category.setText(data.get(position).getCategory());
        //显示数据
        if(data.get(position).getItem().size()!=0){
            StringBuilder stringBuilder2=new StringBuilder();
            stringBuilder2.append("");
            for(int i=0;i<data.get(position).getItem().size();i++){
                stringBuilder2.append(data.get(position).getItem().get(i).getItem_name()).
                        append("  检查结果=").append(data.get(position).getItem().get(i).getVal()).
                        append("  参考值=").append(data.get(position).getItem().get(i).getNormal_val()).append("\r\n");
            }
            stringBuilder2.deleteCharAt(stringBuilder2.length()-1);
            holder.item.setText(stringBuilder2.toString());
        }else{
            holder.item.setVisibility(View.GONE);
        }
        if(data.get(position).getSicknesses().size()!=0){
            StringBuilder stringBuilder2=new StringBuilder();
            stringBuilder2.append("您具有以下疾病的潜在风险：");
            stringBuilder2.append(data.get(position).getSicknesses().get(0));
            /*for(int i=0;i<data.get(position).getSicknesses().size();i++){
                stringBuilder2.append(data.get(position).getSicknesses().get(i)).append("、");
            }
             stringBuilder2.deleteCharAt(stringBuilder2.length()-1);*/

            holder.sickness.setText(stringBuilder2.toString());
            holder.guidence.setText("查看指导意见");
            holder.guidence.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(data.get(position).getGuidence().get(data.get(position).getSicknesses().get(0))!=null){
                        Log.d(TAG,data.get(position).getGuidence().get(data.get(position).getSicknesses().get(0)));
                        Intent intent=new Intent(context,GuidenceActivity.class);
                        intent.putExtra("url",data.get(position).getGuidence().get(data.get(position).getSicknesses().get(0)));
                        context.startActivity(intent);
                    }else{
                        Toast.makeText(context,"数据库尚未收集该数据，且爬虫已被反爬",Toast.LENGTH_SHORT).show();
                    }
                   // Log.d(TAG,data.get(position).getGuidence().get(data.get(position).getSicknesses().get(0)));

                }
            });
        }else{
            holder.sickness.setText("你这部分指标健康");
            holder.guidence.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
