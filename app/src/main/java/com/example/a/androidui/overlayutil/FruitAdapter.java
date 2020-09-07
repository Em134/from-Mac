package com.example.a.androidui.overlayutil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.a.androidui.R;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {


    private Context mContext;
    private List<Fruit> mFruitList;
    private MyOnItemClickListener itemClickListener;
    private MyOnItemLongClickListener itemLongClickListener;


    @Override
    public FruitAdapter.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        if(mContext==null){
            mContext=parent.getContext();
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.fruit_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {


        /*将接收到的ViewHolder强转成自定义的VIewHolder*/
        final ViewHolder myViewHolder = holder;

        Fruit fruit=mFruitList.get(position);
        holder.fruitName.setText(fruit.getName());
        Glide.with(mContext).load(fruit.getImageId()).into(holder.fruitImage);//载入图片




        /*自定义item的点击事件不为null，设置监听事件*/
        if (itemClickListener != null) {
            myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    itemClickListener.OnItemClickListener(myViewHolder.itemView, myViewHolder.getLayoutPosition());
                }
            });
        }

        /*自定义item的长按事件不为null，设置监听事件*/
        if (itemLongClickListener != null) {

            myViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    itemLongClickListener.OnItemLongClickListener(myViewHolder.itemView, myViewHolder.getLayoutPosition());
                    return true;
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return mFruitList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView fruitImage;
        TextView fruitName;

        public ViewHolder( View view) {
            super(view);
            cardView= (CardView) view;
            fruitImage=view.findViewById(R.id.fruit_image);
            fruitName=view.findViewById(R.id.fruit_name);
        }
    }
    public FruitAdapter(List<Fruit> fruitList){
        mFruitList=fruitList;
    }


    /**
     * 列表点击事件
     *
     * @param itemClickListener
     */
    public void setOnItemClickListener(MyOnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    /**
     * 列表长按事件
     *
     * @param itemLongClickListener
     */
    public void setOnItemLongClickListener(MyOnItemLongClickListener itemLongClickListener) {
        this.itemLongClickListener = itemLongClickListener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView idView;
        private TextView nameView;

        public MyViewHolder(View itemView) {
            super(itemView);
            idView = (TextView) itemView.findViewById(R.id.fruit_name);
            nameView = (TextView) itemView.findViewById(R.id.fruit_name);
        }

        public TextView getIdView() {
            return idView;
        }

        public TextView getNameView() {
            return nameView;
        }
    }




}
